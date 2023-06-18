package com.ps2001.shopcorner.ui.screen.cart

import com.ps2001.shopcorner.model.OrderItem

data class CartState(
    val orderItem: List<OrderItem>,
    val totalRequiredPrice: Int
)
