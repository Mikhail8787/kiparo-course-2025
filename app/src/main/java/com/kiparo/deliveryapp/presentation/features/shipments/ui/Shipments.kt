package com.kiparo.deliveryapp.presentation.features.shipments.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.domain.models.ShipmentGroup
import com.kiparo.deliveryapp.domain.models.ShipmentStatus
import com.kiparo.deliveryapp.domain.models.ShipmentType
import com.kiparo.deliveryapp.domain.models.mockShipmentsGroup
import com.kiparo.deliveryapp.presentation.core_ui.theme.space_16
import com.kiparo.deliveryapp.presentation.utils.titleResId

// For Students, read this:
// https://developer.android.com/jetpack/compose/lists

@Composable
fun Shipments(group: ShipmentGroup, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),


        ) {
        val issuedForDelivery = ShipmentStatus.ISSUED_FOR_DELIVERY
        val readyToPickup = ShipmentStatus.READY_TO_PICKUP
        val delivered = ShipmentStatus.DELIVERED



        item {
            ShipmentSectionTitle(title = stringResource(id =ShipmentStatus.READY_TO_PICKUP.titleResId()))
        }

        // Отображение карточек для "Ready to pickup"
        item {
            ShipmentDeliveryCard(
                id = "235678654323567889762229",
//                status = "Issue for delivery",
                sender = "pavel@kiparo.ru",
                status = ShipmentStatus.ISSUED_FOR_DELIVERY,
                imageResId = ShipmentType.COURIER,
                status2 = ""
            ) // Передаем каждую карточку
        }
        item {
            Spacer(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .height(space_16)
                    .fillMaxSize()
            ) // Spacer между карточками
        }
        item {
            ShipmentDeliveryCard(
                id = "235678654323567889762230",
//                status = "Ready to pickup",
                sender = "timofey@kipro.ru",
                status = ShipmentStatus.READY_TO_PICKUP,
                imageResId = ShipmentType.PARCEL_LOCKER,
                status2 = stringResource(id = R.string.waiting_picked_up_to)
            )
        }

        item {
            ShipmentSectionTitle(title = stringResource(id = ShipmentStatus.OTHER.titleResId()))
        }

        item {
            ShipmentDeliveryCard(
                id = "235678654323567889762230",
//                status = "Delivered",
                sender = "Konstantin Ivanov",
                status = ShipmentStatus.DELIVERED,
                imageResId = ShipmentType.PARCEL_LOCKER,
                status2 = stringResource(id = R.string.status_delivered)
            ) // Передаем каждую карточку
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun preview() {
    Shipments(group = mockShipmentsGroup())
//    DeliveryCard()
}