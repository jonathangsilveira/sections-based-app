package com.example.jonathan.sectionsapp

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.component.ItemAdapter
import com.example.jonathan.sectionsapp.component.HomeCommandReceiver
import com.example.jonathan.sectionsapp.decoration.VerticalItemDecorator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private val itemsAdapter: ItemAdapter<HomeCommandReceiver> by lazy {
        ItemAdapter(viewModel::processCommand)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar()
        setupRecyclerView()
        subscribeObservers()
        viewModel.refresh()
    }

    private fun subscribeObservers() {
        viewModel.stateObserver.observe(this) {
            val progressBar = findViewById<ProgressBar>(R.id.progressBar)
            progressBar.isVisible = it.isLoading
            itemsAdapter.submitItems(it.results)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.items)
        with(recyclerView) {
            setVerticalLayoutManager(reverseLayout = false)
            adapter = itemsAdapter
            addItemDecoration(
                VerticalItemDecorator(
                    top = R.dimen.no_margin,
                    bottom = R.dimen.margin_04
                )
            )
        }
    }

    private fun setupActionBar() {
        supportActionBar?.setTitle(R.string.home_greeting)
    }
}