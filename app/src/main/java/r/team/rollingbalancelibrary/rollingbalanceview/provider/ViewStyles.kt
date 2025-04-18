package r.team.rollingbalancelibrary.rollingbalanceview.provider

import r.team.rollingbalancelibrary.rollingbalanceview.utils.dp

data class DigitViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

data class CurrencyViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

data class DotViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

data class SpaceViewStyle(
    val spaceWidth: Int = 4.dp
)
