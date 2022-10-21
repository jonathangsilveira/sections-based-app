package com.example.jonathan.sectionsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.component.ComponentListAdapter
import com.example.jonathan.component.ViewHolderComponent
import com.example.jonathan.domain.model.item.ShortcutItem
import com.example.jonathan.domain.model.properties.Cover
import com.example.jonathan.domain.model.properties.SizeType
import com.example.jonathan.domain.model.section.GridSection
import com.example.jonathan.sectionsapp.component.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val providedItems = provideGrid()
        val sectionItem = GridComponent(
            item = GridSection(
                id = 0,
                header = null,
                columnsCount = 2,
                items = providedItems
            ),
            itemDecorator = GridItemDecorator(
                top = R.dimen.no_margin,
                bottom = R.dimen.margin_02,
                start = R.dimen.default_margin,
                end = R.dimen.default_margin
            )
        )
        val sectionItems = providedItems.mapIndexed { position, item ->
            LatestPlaylistComponent(
                shortcut = item,
                onClick = {
                    println("Playlist ${item.title} clicked at position $position")
                }
            )
        }
        sectionItem.addAll(sectionItems)
        val recyclerView = findViewById<RecyclerView>(R.id.items)
        val componentAdapter = ComponentListAdapter()
        componentAdapter.submitList(
            listOf(
                HeaderComponent("Made For Jonathan Giorgi Silveira"),
                provideRecentSearches(),
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
        recyclerView.adapter = componentAdapter
    }

    private fun provideGrid(): List<ShortcutItem> {
        return List(4) { index ->
            ShortcutItem(
                id = index,
                isPlaying = index == 0,
                size = SizeType.SMALL,
                cover = Cover(
                    size = SizeType.SMALL,
                    url = null
                ),
                title = "Playlist ${index.inc()}"
            )
        }
    }

    private fun provideCarousel(): CarouselComponent {
        val component = CarouselComponent(
            itemDecoration = HorizontalItemDecorator(
                end = R.dimen.margin_02,
                start = R.dimen.no_margin
            )
        )
        component.addAll(
            List(8) {
                AlbumComponent(
                    title = "Album #${it}",
                    subtitle = "Artist #${it}"
                )
            }
        )
        return component
    }

    private fun provideRecentSearches(): ViewHolderComponent {
        val container = ListComponent(
            itemDecoration = VerticalItemDecorator(
                top = R.dimen.no_margin,
                bottom = R.dimen.margin_02
            )
        )
        container.addAll(
            listOf(
                RowComponent(
                    coverResId = R.drawable.brave_new_world,
                    title = "Brave New World",
                    subtitle = "Song - Iron Maiden",
                    trailingIconResId = R.drawable.ic_round_close_24,
                    onTrailingIconClick = { container.remove(it) }
                ),
                RowComponent(
                    coverResId = R.drawable.brave_new_world,
                    title = "The Mercenary",
                    subtitle = "Song - Iron Maiden",
                    trailingIconResId = R.drawable.ic_round_close_24,
                    onTrailingIconClick = { container.remove(it) }
                ),
                RowComponent(
                    coverResId = R.drawable.brave_new_world,
                    title = "Blood Brothers",
                    subtitle = "Song - Iron Maiden",
                    trailingIconResId = R.drawable.ic_round_close_24,
                    onTrailingIconClick = { container.remove(it) }
                )
            )
        )
        container.setPlaceholder(MessageComponent("Ops! Your section is empty ?;)"))
        return container
    }
}