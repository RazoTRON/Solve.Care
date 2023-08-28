package com.test.solvecare.data

import com.test.solvecare.data.model.DataResponse
import com.test.solvecare.data.model.toDomainModel
import com.test.solvecare.domain.BoxRepository
import com.test.solvecare.domain.model.BoxProperties
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class BoxRepositoryImpl : BoxRepository {

    @OptIn(ExperimentalSerializationApi::class)
    override fun get(path: String): BoxProperties {
        val json = """
            {
               "spaceBetweenBox" : 10,
               "boxColor" : "ED05265A",
               "boxes" : [
                     {
                        "id" : 1,
                        "width" : 300,
                        "height" : 50
                     },
                     {
                        "id" : 2,
                        "width" : 350,
                        "height" : 80
                     },
                     {
                        "id" : 3,
                        "width" : 400,
                        "height" : 30
                     }
                  ]
            }
        """.trimIndent()

        val response = Json.decodeFromString<DataResponse>(json)

        return response.toDomainModel()
    }
}