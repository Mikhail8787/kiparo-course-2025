package com.kiparo.deliveryapp.presentation.features.shipments.ui

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiparo.deliveryapp.presentation.core_ui.theme.space_16

@Composable
fun ShipmentSectionTitle(title: String,
                         modifier: Modifier = Modifier,
                         backgroundColor: Color = MaterialTheme.colorScheme.background) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(backgroundColor)) {
        Spacer(modifier = Modifier.size(space_16))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(backgroundColor)
            ) {
                Divider(
                    modifier = Modifier
                        .width(86.5.dp)
                        .height(1.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
                Spacer(modifier = Modifier.size(space_16))
                Text(
                    modifier = modifier,
                    text = title,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.size(space_16))
                Divider(
                    modifier = Modifier
                        .width(85.dp)
                        .height(1.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
        Spacer(modifier = Modifier.size(space_16))
    }
}

@Preview
@Composable
private fun Preview() {
    ShipmentSectionTitle(title = "Ready to Pick-up")
}