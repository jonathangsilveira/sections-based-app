package com.example.jonathan.sectionsapp.domain.mapper

import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.properties.Header
import com.example.jonathan.sectionsapp.component.HeaderComponent

internal class HeaderMapper: Mapper<Header, HeaderComponent> {
    override fun map(value: Header): HeaderComponent {
        return HeaderComponent(value.title)
    }
}