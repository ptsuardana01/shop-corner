package com.ps2001.shopcorner.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps2001.shopcorner.data.ItemRepository
import com.ps2001.shopcorner.model.Item
import com.ps2001.shopcorner.model.OrderItem
import com.ps2001.shopcorner.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: ItemRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderItem>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderItem>>
        get() = _uiState


    fun getOrderById(itemId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderItemById(itemId))
        }
    }

    fun addToCart(item: Item, count: Int) {
        viewModelScope.launch {
            repository.updateOrderItem(item.id, count)
        }
    }
}