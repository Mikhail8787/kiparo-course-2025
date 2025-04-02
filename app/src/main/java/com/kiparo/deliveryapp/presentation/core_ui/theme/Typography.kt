/*
 * Copyright (c) 2023. Kiparo academy
 */

package com.kiparo.deliveryapp.presentation.core_ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// For Students, read this:
// https://developer.android.com/jetpack/compose/designsystems/material3#typography

val Typography = Typography(
    titleSmall = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    bodySmall = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp

    ),



    bodyMedium = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp,
        letterSpacing = 0.4.sp
    ),
    labelSmall = TextStyle(
        fontFamily = montserratFontFamily,
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    )
)

val Typography.bodyMediumBold: TextStyle
    @Composable
    get() {
        return TextStyle(
            fontFamily = montserratFontFamily,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            letterSpacing = 0.4.sp
        )
    }








