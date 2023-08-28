package com.test.solvecare.domain

import com.test.solvecare.domain.model.BoxProperties

interface BoxRepository {
    fun get(path: String): BoxProperties
}
