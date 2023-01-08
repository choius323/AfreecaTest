package com.choius323.afreecatest.ui.broad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choius323.domain.model.Category
import com.choius323.domain.usecase.GetAllCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BroadViewModel @Inject constructor(
    private val getAllCategories: GetAllCategories
) : ViewModel() {

    private val _categoryList = MutableLiveData<List<Category>>()
    val categoryList: LiveData<List<Category>> get() = _categoryList

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val categoryList = getAllCategories.invoke()
                Log.d("BroadViewModel", "init: $categoryList")
                _categoryList.postValue(categoryList)
            }
        }
    }
}