package com.ps2001.shopcorner.di

import com.ps2001.shopcorner.data.ItemRepository

object Injection {
    fun provideRepository(): ItemRepository {
        return ItemRepository.getInstance()
    }
}