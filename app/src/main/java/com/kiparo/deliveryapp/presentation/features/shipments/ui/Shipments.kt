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
            ShipmentSectionTitle(title = "Ready to pickup")
        }

        // Отображение карточек для "Ready to pickup"
        item {
            ShipmentDeliveryCard(
                id = "235678654323567889762229",
//                status = "Issue for delivery",
                sender = "pavel@kiparo.ru",
                status = issuedForDelivery,
                imageResId = ShipmentType.COURIER,
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
                status = readyToPickup,
                imageResId = ShipmentType.PARCEL_LOCKER
            )
        }


        item {
            ShipmentSectionTitle(title = "Others")
        }

        item {
            ShipmentDeliveryCard(
                id = "235678654323567889762230",
//                status = "Delivered",
                sender = "Konstantin Ivanov",
                status = delivered,
                imageResId = ShipmentType.PARCEL_LOCKER
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