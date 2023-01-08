package com.choius323.afreecatest.ui.broad

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.choius323.afreecatest.KEY_CATEGORY
import com.choius323.domain.model.Category
import com.choius323.domain.usecase.GetBroadPagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BroadListViewModel @Inject constructor(
    broadPagingUseCase: GetBroadPagingUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _category = savedStateHandle.getStateFlow<Category?>(KEY_CATEGORY, null)

    val broadList = broadPagingUseCase(_category.value).cachedIn(viewModelScope)
}