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
import androidx.compose.ui.unit.sp
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.domain.models.Customer
import com.kiparo.deliveryapp.domain.models.ShipmentStatus
import com.kiparo.deliveryapp.domain.models.ShipmentType
import com.kiparo.deliveryapp.presentation.core_ui.theme.bodyMediumBold
import com.kiparo.deliveryapp.presentation.utils.formatDateTime
import com.kiparo.deliveryapp.presentation.utils.iconResId
import com.kiparo.deliveryapp.presentation.utils.titleResId
import java.time.ZonedDateTime
import java.time.temporal.Temporal

@Composable
fun ShipmentDeliveryCard(
    id: String,
    status: ShipmentStatus,
    sender: String,
    imageResId: ShipmentType,
    modifier: Modifier = Modifier,

) {
    val backgroundColor = MaterialTheme.colorScheme.surface
    val paint = painterResource(id = imageResId.iconResId())
    val title = stringResource(id = status.titleResId())
    var date = ""
    val status2 = ""
    val customer1 =Customer(name = null,
        phoneNumber = "84564",
        email = "pavel@kiparo.ru"
        )
    val customer2 =Customer(name = null,
        phoneNumber = "84564",
        email = "timofey@kiparo.com"
    )
    val customer3 =Customer(name = "Konstantin Ivanov",
        phoneNumber = "84564",
        email = "email"
    )
    Column {
        Card(
            modifier = modifier
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
                        painter = painterResource(id = imageResId.iconResId()), // Replace with your actual image resource
                        contentDescription = stringResource(R.string.delivery_truck),
                        modifier = modifier.size(48.dp)
                    )
                }
                Spacer(modifier = modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Status
                    Column {
                        Text(
                            text = stringResource(R.string.status).uppercase(),
                            style = MaterialTheme.typography.titleSmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            text = stringResource(id = status.titleResId()),
                            style = MaterialTheme.typography.bodyMediumBold,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        when (status) {
                            ShipmentStatus.READY_TO_PICKUP -> {
                                date = formatDateTime(ZonedDateTime.now())
                            }
                            ShipmentStatus.DELIVERED -> {
                                date = formatDateTime(ZonedDateTime.now())
                            }
                            else -> {
                            }
                        }
                    }
                    Column {
                        Text(
                            text = stringResource(R.string.status).uppercase(),
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Text(
                            text = date,
//                            formatDateTime(ZonedDateTime.now()),
                            style = MaterialTheme.typography.bodySmall,
                        )
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
                            text = stringResource(R.string.sender).uppercase(),
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = customer1.name ?: customer1.email,
                            style = MaterialTheme.typography.bodyMediumBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor),
                        contentPadding = PaddingValues(0.dp),
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
        status = ShipmentStatus.NOT_READY,
        sender = "pavel@kiparo.ru",
    )
}