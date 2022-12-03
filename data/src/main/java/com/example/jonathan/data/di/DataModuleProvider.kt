package com.example.jonathan.data.di

import com.example.jonathan.data.HomeRepositoryImpl
import com.example.jonathan.data.Key
import com.example.jonathan.data.mapper.*
import com.example.jonathan.data.response.item.AlbumItemResponse
import com.example.jonathan.data.response.item.RecentlyPlayedItemResponse
import com.example.jonathan.data.response.item.RowItemResponse
import com.example.jonathan.data.response.item.SectionItemResponse
import com.example.jonathan.data.source.RemoteDataSourceImpl
import com.example.jonathan.domain.model.properties.ItemType
import com.example.jonathan.domain.repository.HomeRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val dataModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("X-Parse-Application-Id", Key.APP_ID)
                    .addHeader("X-Parse-REST-API-Key", Key.KEY)
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    factory {
        val contentType = "application/json".toMediaType()
        val json = Json {
            explicitNulls = false
            prettyPrint = true
            serializersModule = SerializersModule {
                polymorphic(SectionItemResponse::class) {
                    subclass(AlbumItemResponse::class)
                    subclass(RecentlyPlayedItemResponse::class)
                    subclass(RowItemResponse::class)
                }
            }
        }
        Retrofit.Builder()
            .baseUrl("https://parseapi.back4app.com/parse/functions/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(get<OkHttpClient>())
            .build()
    }

    @Suppress("UNCHECKED_CAST")
    factory<HomeRepository> {
        val sizeMapper = SizeMapper()
        val coverMapper = CoverMapper(sizeMapper)
        HomeRepositoryImpl(
            remoteDataSource = RemoteDataSourceImpl(
                homeService = get<Retrofit>().create(),
                mapper = SectionMapper(
                    headerMapper = HeaderMapper(coverMapper),
                    configMapper = ConfigMapper(),
                    itemTypeMapper = ItemTypeMapper(),
                    itemsMapper = mapOf(
                        ItemType.ALBUM to AlbumItemMapper(
                            coverMapper = coverMapper,
                            sizeMapper = sizeMapper
                        ),
                        ItemType.RECENTLY_PLAYED to RecentlyPlayedItemMapper(
                            coverMapper = coverMapper,
                            sizeMapper = sizeMapper
                        ),
                        ItemType.ROW to RowItemMapper(
                            coverMapper = coverMapper,
                            sizeMapper = sizeMapper
                        )
                    ) as Map<ItemType, ItemMapper<SectionItemResponse>>
                )
            )
        )
    }
}