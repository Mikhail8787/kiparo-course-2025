package com.kiparo.deliveryapp.presentation.features.shipments.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.presentation.utils.formatDateTime
import java.time.ZonedDateTime
import java.time.temporal.Temporal

@Composable
fun ShipmentDeliveryCard(
    id: String,
    status: String,
    sender: String,
    imageResId:Int,
    modifier: Modifier = Modifier
) {
    val backgroundColor = MaterialTheme.colorScheme.surface
    val buttonBackgroundColor = MaterialTheme.colorScheme.background
    Column {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
        ) {
            Column(
                modifier = modifier
                    .background(backgroundColor)
                    .padding(16.dp)
            ) {

                // ID
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.id),
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = id,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(id = imageResId), // Replace with your actual image resource
                        contentDescription = stringResource(R.string.delivery_truck),
                        modifier = modifier.size(48.dp)
                    )
                }
                Spacer(modifier = modifier.height(8.dp))

                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    // Status
                    Column {
                        Text(
                            text = stringResource(R.string.status).uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = status,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column {
                        Text(
                            text = stringResource(R.string.status).uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Row {
                            formatDateTime(ZonedDateTime.now())
                            Text(
                                text = formatDateTime(ZonedDateTime.now()),
                                style = MaterialTheme.typography.bodySmall,
                            )

                        }

                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Sender
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.sender),
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        Text(
                            text = sender,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor),
                        contentPadding = PaddingValues(0.dp)

                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = stringResource(R.string.more),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface) //bodySmallBold
                            Image(
                                painter = painterResource(id = R.drawable.ic_arrowright),
                                contentDescription = stringResource(R.string.delivery_truck),
                            )

                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ShipmentDeliveryCard(
        id = "235678654323567889762229",
        status ="Issued for delivery",
        imageResId = R.drawable.ic_auto,
        sender = "pavel@kipro.ru"
    )
}