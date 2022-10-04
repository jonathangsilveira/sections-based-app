package com.example.jonathan.sectionsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.Shape
import com.example.jonathan.domain.model.properties.SizeType
import com.example.jonathan.domain.model.properties.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val providedItems = provideGrid()
        val sectionItem = GridUIComponent()
        val sectionItems = providedItems.mapIndexed { position, item ->
            PlaylistUIComponent(
                playlistItem = item,
                onClick = {
                    println("Playlist ${item.title.value} clicked at position $position")
                    sectionItem.remove(it)
                }
            )
        }
        sectionItem.addAll(sectionItems)
        sectionItem.setPlaceholder(MessageUIComponent("Ops! Your section is empty ?;)"))
        val recyclerView = findViewById<RecyclerView>(R.id.items)
        val UIComponentAdapter = com.example.jonathan.component.UIComponentAdapter()
        UIComponentAdapter.update(
            listOf(
                BannerUIComponent(
                    title = "Playlists",
                    onClick = { println("Banner clicked") }
                ),
                sectionItem,
                HeaderUIComponent("Made For Jonathan Giorgi Silveira"),
                provideCarousel(),
                BannerUIComponent(
                    title = "Another Banner",
                    onClick = { println("Banner clicked") }
                ),
                provideCarousel(),
                HeaderUIComponent("Other sections"),
                BannerUIComponent(
                    title = "Final Banner",
                    onClick = { println("Banner clicked") }
                )
            )
        )
        recyclerView.adapter = UIComponentAdapter
    }

    private fun provideGrid(): List<com.example.jonathan.domain.model.item.PlaylistItem> {
        return List(4) { index ->
            com.example.jonathan.domain.model.item.PlaylistItem(
                id = index,
                isRecentPlayed = index == 0,
                size = com.example.jonathan.domain.model.properties.SizeType.SMALL,
                cover = com.example.jonathan.domain.model.properties.Cover(
                    size = com.example.jonathan.domain.model.properties.SizeType.SMALL,
                    shape = com.example.jonathan.domain.model.properties.Shape.SQUARE,
                    rounded = true,
                    url = null
                ),
                title = com.example.jonathan.domain.model.properties.Text(
                    value = "Playlist ${index.inc()}",
                    style = com.example.jonathan.domain.model.properties.Text.Style.BOLD,
                    appearance = com.example.jonathan.domain.model.properties.Text.Appearance(
                        size = com.example.jonathan.domain.model.properties.SizeType.SMALL
                    )
                )
            )
        }
    }

    private fun provideCarousel(): CarouselUIComponent {
        return CarouselUIComponent(
            items = List(8) {
                AlbumUIComponent(
                    title = "Album #${it}",
                    subtitle = "Artist #${it}"
                )
            }
        )
    }
}