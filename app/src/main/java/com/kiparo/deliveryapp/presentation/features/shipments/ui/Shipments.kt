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
import androidx.compose.ui.tooling.preview.Preview
import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.domain.models.Customer
import com.kiparo.deliveryapp.domain.models.Shipment
import com.kiparo.deliveryapp.domain.models.ShipmentGroup
import com.kiparo.deliveryapp.domain.models.ShipmentStatus
import com.kiparo.deliveryapp.domain.models.ShipmentType
import com.kiparo.deliveryapp.domain.models.mockShipment
import com.kiparo.deliveryapp.domain.models.mockShipments
import com.kiparo.deliveryapp.domain.models.mockShipmentsGroup
import com.kiparo.deliveryapp.presentation.core_ui.theme.space_16
import com.kiparo.deliveryapp.presentation.utils.titleResId

// For Students, read this:
// https://developer.android.com/jetpack/compose/lists

@Composable
fun Shipments(group: ShipmentGroup, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        // Отображаем "highlighted" карточки
        if (group.highlights.isNotEmpty()) {
            item {
                ShipmentSectionTitle(title = stringResource(id = R.string.ready_to_pickup))
            }
            group.highlights.forEach { shipment ->
                item {
                    ShipmentDeliveryCard(
                        id = shipment.number,
                        sender = shipment.sender ?: Customer("", "", ""),
                        status = shipment.status,
                        imageResId = shipment.type,
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(space_16)) // Отступ между карточками
                }
            }
        }

        // Отображаем "others" карточки
        if (group.others.isNotEmpty()) {
            item {
                ShipmentSectionTitle(title = stringResource(id = R.string.others))
            }
            group.others.forEach { shipment ->
                item {
                    ShipmentDeliveryCard(
                        id = shipment.number,
                        sender = shipment.sender ?: Customer("", "", ""),
                        status = shipment.status,
                        imageResId = shipment.type,
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(space_16)) // Отступ между карточками
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val mockGroup =
        mockShipmentsGroup()
//    ShipmentGroup(
//        highlights = listOf(
//            Shipment("12345", ShipmentType.COURIER, ShipmentStatus.READY_TO_PICKUP, null, null, null, null, null, true),
//            Shipment("67890", ShipmentType.PARCEL_LOCKER, ShipmentStatus.DELIVERED, null, null, null, null, null, true)
//        ),
//        others = listOf(
//            Shipment("54321", ShipmentType.COURIER, ShipmentStatus.ISSUED_FOR_DELIVERY, null, null, null, null, null, false)
//        )
//    )
    Shipments(group = mockGroup)
}












//@Composable
//fun Shipments(group: ShipmentGroup, modifier: Modifier = Modifier) {
//    LazyColumn(
//        modifier = modifier.fillMaxSize()
//    ) {
//        // Заголовок для READY_TO_PICKUP
//        item {
//            ShipmentSectionTitle(
//                title = stringResource(
//                    id =
//                    ShipmentStatus.READY_TO_PICKUP.titleResId()
//                )
//            )
//        }
//        // Карточки для READY_TO_PICKUP
//        item {
//            ShipmentDeliveryCard(
//                id = "235678654323567889762229",
//                sender = Customer("pavel@kiparo.ru", "phoneNum", ""),
//                status = ShipmentStatus.ISSUED_FOR_DELIVERY,
//                imageResId = ShipmentType.COURIER,
//                status2 = ""
//            ) // Передаем каждую карточку
//        }
//        item {
//            Spacer(modifier = Modifier.height(space_16)) // Spacer между карточками
//        }
//        item {
//            ShipmentDeliveryCard(
//                id = "235678654323567889762230",
//                sender = Customer("timofey@kipro.ru", "phoneNum", ""),
//                status = ShipmentStatus.READY_TO_PICKUP,
//                imageResId = ShipmentType.PARCEL_LOCKER,
//                status2 = stringResource(id = R.string.waiting_picked_up_to)
//            )
//        }
//        // Заголовок для OTHER
//        item {
//            ShipmentSectionTitle(title = stringResource(id = ShipmentStatus.OTHER.titleResId()))
//        }
//
//        // Карточка для DELIVERED
//        item {
//            ShipmentDeliveryCard(
//                id = "235678654323567889762230",
//                sender = Customer("email", "phoneNum", "Konstantin Ivanov"),
//                status = ShipmentStatus.DELIVERED,
//                imageResId = ShipmentType.PARCEL_LOCKER,
//                status2 = stringResource(id = R.string.status_delivered)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    Shipments(group = mockShipmentsGroup())
//}