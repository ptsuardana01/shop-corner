package com.ps2001.shopcorner

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.ps2001.shopcorner.ui.theme.ShopCornerTheme

@Composable
fun ShopCornerApp(
    modifier: Modifier = Modifier,
) {

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ShopCornerAppPreview() {
    ShopCornerTheme {
        ShopCornerApp()
    }
}