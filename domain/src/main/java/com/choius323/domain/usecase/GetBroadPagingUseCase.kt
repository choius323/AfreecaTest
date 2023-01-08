package com.choius323.domain.usecase

import com.choius323.domain.model.Category
import com.choius323.domain.repository.BroadRepository
import javax.inject.Inject

class GetBroadPagingUseCase @Inject constructor(
    private val broadRepository: BroadRepository
) {
    operator fun invoke(category: Category?) =
        broadRepository.getBroadList(category ?: Category("", ""))
}