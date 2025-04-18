package r.team.rollingbalance.rollingbalanceview.provider

import r.team.rollingbalance.rollingbalanceview.utils.dp

public data class DigitViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

public data class CurrencyViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

public data class DotViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

public data class SpaceViewStyle(
    val spaceWidth: Int = 4.dp
)
