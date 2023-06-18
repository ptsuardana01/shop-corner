package com.ps2001.shopcorner.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ps2001.shopcorner.di.Injection
import com.ps2001.shopcorner.model.OrderItem
import com.ps2001.shopcorner.ui.ViewModelFactory
import com.ps2001.shopcorner.ui.common.UiState
import com.ps2001.shopcorner.ui.components.Item

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigationDetail: (Long) -> Unit,
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllItems()
            }

            is UiState.Success -> {
                HomeContent(
                    orderItem = uiState.data,
                    modifier = modifier,
                    navigationDetail = navigationDetail
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    orderItem: List<OrderItem>,
    navigationDetail: (Long) -> Unit,
    modifier: Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(orderItem) { data ->
            Item(
                image = data.item.image,
                title = data.item.title,
                requiredPoint = data.item.price,
                modifier = Modifier.clickable {
                    navigationDetail(data.item.id)
                }
            )
        }
    }
}
