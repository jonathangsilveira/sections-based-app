package com.example.jonathan.sectionsapp

import androidx.viewbinding.ViewBinding

class BindingItemViewHolder<VB: ViewBinding>(
    val binding: VB
): ItemViewHolder(binding.root)