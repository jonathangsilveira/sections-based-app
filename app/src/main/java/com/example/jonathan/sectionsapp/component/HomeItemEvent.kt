package com.example.jonathan.sectionsapp.component

import com.example.jonathan.component.ViewHolderItemEvent

sealed class HomeItemEvent: ViewHolderItemEvent {
    object ItemClicked: HomeItemEvent()
    object ItemLongClicked: HomeItemEvent()
    object RemoveItemClicked: HomeItemEvent()
}
