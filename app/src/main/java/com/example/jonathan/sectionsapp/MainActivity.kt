package com.example.jonathan.sectionsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val providedItems = provideGrid()
        val sectionItem = GridComponent()
        val sectionItems = providedItems.mapIndexed { position, item ->
            PlaylistComponent(
                playlistItem = item,
                onClick = {
                    println("Playlist ${item.title.value} clicked at position $position")
                    sectionItem.remove(it)
                }
            )
        }
        sectionItem.addAll(sectionItems)
        sectionItem.setPlaceholder(MessageComponent("Ops! Your section is empty ?;)"))
        val recyclerView = findViewById<RecyclerView>(R.id.items)
        val UIComponentAdapter = com.example.jonathan.component.ViewHolderComponentAdapter()
        UIComponentAdapter.update(
            listOf(
                BannerComponent(
                    title = "Playlists",
                    onClick = { println("Banner clicked") }
                ),
                sectionItem,
                HeaderComponent("Made For Jonathan Giorgi Silveira"),
                provideCarousel(),
                BannerComponent(
                    title = "Another Banner",
                    onClick = { println("Banner clicked") }
                ),
                provideCarousel(),
                HeaderComponent("Other sections"),
                BannerComponent(
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

    private fun provideCarousel(): CarouselComponent {
        return CarouselComponent(
            items = List(8) {
                AlbumComponent(
                    title = "Album #${it}",
                    subtitle = "Artist #${it}"
                )
            }
        )
    }
}