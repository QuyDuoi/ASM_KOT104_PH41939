package com.quyduoi.asm_kot104_md18309_ph41939.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.quyduoi.asm_kot104_md18309_ph41939.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val gelasioFontFamily = FontFamily (
    Font(R.font.gelasio_variablefont_wght)
)

val gelasioBold = FontFamily(
    Font(R.font.gelasio_bold)
)

val merriweatherFontFamily = FontFamily(
    Font(R.font.merriweather_black)
)

val merriBold = FontFamily(
    Font(R.font.merriweather_bold, FontWeight.Bold)
)

val nunitosanFontFamily = FontFamily(
    Font(R.font.nunitosans_variable)
)

val nunitosanBold = FontFamily(
    Font(R.font.nunitosans_bold, FontWeight.Bold)
)