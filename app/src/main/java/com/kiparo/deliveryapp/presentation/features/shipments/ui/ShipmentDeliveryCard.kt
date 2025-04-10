package com.kiparo.deliveryapp.presentation.features.shipments.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.domain.models.Customer
import com.kiparo.deliveryapp.domain.models.ShipmentStatus
import com.kiparo.deliveryapp.domain.models.ShipmentType
import com.kiparo.deliveryapp.presentation.core_ui.theme.bodyMediumBold
import com.kiparo.deliveryapp.presentation.utils.iconResId
import com.kiparo.deliveryapp.presentation.utils.titleResId

@Composable
fun ShipmentDeliveryCard(
    id: String,
    status: ShipmentStatus,
    sender: Customer,
    imageResId: ShipmentType,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = MaterialTheme.colorScheme.surface
    val (date, status2) = getDate(status)
    val senderText = sender.name.takeIf { it.isNotBlank() } ?: sender.email

    Column {
        Card(
            modifier = Modifier
                .background(backgroundColor)
                .wrapContentHeight()
                .wrapContentSize()
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
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = id,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                    Image(
                        painter = painterResource(id = imageResId.iconResId()),
                        contentDescription = stringResource(R.string.delivery_truck),
                        modifier = modifier.size(48.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),

                ) {
                    // Status
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(R.string.status).uppercase(),
                            style = MaterialTheme.typography.titleSmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            text = stringResource(id = status.titleResId()),
                            style = MaterialTheme.typography.bodyMediumBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = status2.uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = date,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
                }

                // Sender
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(1f)){
                        Text(
                            text = stringResource(R.string.sender).uppercase(),
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = senderText,
                            style = MaterialTheme.typography.bodyMediumBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(R.string.more),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            ) //bodySmallBold
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
        imageResId = ShipmentType.COURIER,
        status = ShipmentStatus.READY_TO_PICKUP,
        sender = Customer("email", "phoneNumber", "name"),
    )
}