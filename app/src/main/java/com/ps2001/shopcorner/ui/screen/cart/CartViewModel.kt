package com.ps2001.shopcorner.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ps2001.shopcorner.data.ItemRepository
import com.ps2001.shopcorner.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: ItemRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<CartState>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<CartState>>
        get() = _uiState

    fun getAddedOrderItems() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getAddedOrderItems()
                .collect { orderItem ->
                    val totalRequiredPoint =
                        orderItem.sumOf { it.item.price * it.count }
                    _uiState.value = UiState.Success(CartState(orderItem, totalRequiredPoint))
                }
        }
    }
    fun updateOrderItem(itemId: Long, count: Int) {
        viewModelScope.launch {
            repository.updateOrderItem(itemId, count)
                .collect { isUpdated ->
                    if (isUpdated) {
                        getAddedOrderItems()
                    }
                }
        }
    }


}