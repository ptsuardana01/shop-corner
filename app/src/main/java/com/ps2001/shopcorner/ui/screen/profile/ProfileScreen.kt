package com.ps2001.shopcorner.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ps2001.shopcorner.R
import com.ps2001.shopcorner.ui.theme.ShopCornerTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = stringResource(R.string.desc_about),
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(R.string.about_name),
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(vertical = 16.dp)
            )
            Text(
                text = stringResource(R.string.about_contact),
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ProfileScreenPreview() {
    ShopCornerTheme {
        ProfileScreen()
    }
}