package com.kiparo.deliveryapp.presentation.features.shipments.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.presentation.core_ui.theme.bodyMediumBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShipmentsTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(modifier = modifier.background(MaterialTheme.colorScheme.onSurface),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyMediumBold,
                modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 181.dp, bottom = 16.dp)
            )
        }
    )
}

@Composable
@Preview
private fun Preview() {
    ShipmentsTopBar()
}