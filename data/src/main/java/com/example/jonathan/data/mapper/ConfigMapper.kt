package com.example.jonathan.data.mapper

import com.example.jonathan.data.response.property.ConfigResponse
import com.example.jonathan.data.response.property.LayoutResponse
import com.example.jonathan.data.response.property.OrientationResponse
import com.example.jonathan.domain.mapper.Mapper
import com.example.jonathan.domain.model.properties.Config
import com.example.jonathan.domain.model.properties.Layout
import com.example.jonathan.domain.model.properties.Orientation

internal class ConfigMapper: Mapper<ConfigResponse, Config> {
    override fun map(value: ConfigResponse): Config {
        return Config(
            layout = value.layout.asDomain(),
            orientation = value.orientation.asDomain(),
            columns = value.columns
        )
    }

    private fun LayoutResponse.asDomain(): Layout = when (this) {
        LayoutResponse.GRID -> Layout.GRID
        LayoutResponse.LINEAR -> Layout.LINEAR
    }

    private fun OrientationResponse.asDomain(): Orientation = when (this) {
        OrientationResponse.HORIZONTAL -> Orientation.HORIZONTAL
        OrientationResponse.VERTICAL -> Orientation.VERTICAL
    }
}