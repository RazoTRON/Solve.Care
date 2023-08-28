package com.test.solvecare.domain

import android.util.Log
import com.test.solvecare.domain.model.BoxProperties

class GetRepositoryUseCase(private val repository: BoxRepository) {
    fun execute(path: String): BoxProperties {
        return try {
            repository.get(path)
        } catch (e: Exception) {
            Log.d(this.javaClass.canonicalName, e.localizedMessage ?: "Unknown error")

            // Should be changed to Result.Exception for example to handle on UI.
            BoxProperties(0, 0, listOf())
        }
    }
}