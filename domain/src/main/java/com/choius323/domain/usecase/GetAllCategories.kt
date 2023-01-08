package com.choius323.domain.usecase

import com.choius323.domain.repository.BroadRepository
import javax.inject.Inject

class GetAllCategories @Inject constructor(
    private val repository: BroadRepository
) {
    suspend operator fun invoke() = repository.getCategory()
}