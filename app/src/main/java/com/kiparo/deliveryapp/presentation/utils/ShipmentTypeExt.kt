package com.kiparo.deliveryapp.presentation.utils

import com.kiparo.deliveryapp.R
import com.kiparo.deliveryapp.domain.models.ShipmentType

fun ShipmentType.iconResId(): Int =
    when (this) {
        ShipmentType.PARCEL_LOCKER -> {
            // TODO Implement
            // R.drawable.ic_locker
            R.drawable.ic_build
        }

        ShipmentType.COURIER -> {
            // TODO Implement
            // R.drawable.ic_vehicle
//            -1
            R.drawable.ic_auto
        }
    }

