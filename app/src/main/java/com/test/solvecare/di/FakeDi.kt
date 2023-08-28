package com.test.solvecare.di

import com.test.solvecare.data.BoxRepositoryImpl
import com.test.solvecare.domain.BoxRepository
import com.test.solvecare.domain.GetRepositoryUseCase

object FakeDi {
    val repository: BoxRepository = BoxRepositoryImpl()

    val getRepositoryUseCase: GetRepositoryUseCase = GetRepositoryUseCase(repository)
}