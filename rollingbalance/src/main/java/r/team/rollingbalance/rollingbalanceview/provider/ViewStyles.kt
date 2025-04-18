package r.team.rollingbalance.rollingbalanceview.provider

import r.team.rollingbalance.rollingbalanceview.utils.dp

/**
 * Defines the style for the digit view of the balance.
 * This class allows you to customize the appearance of the digits displayed in the balance,
 * including text size, color, and font.
 *
 * @property textSize The text size for the digits, in SP (scaled pixels). Default is 18f.
 * @property textColorRes The resource ID for the text color of the digits. Default is black.
 * @property fontResId The resource ID for the custom font to be applied to the digits. Default is null, which means the default font will be used.
 */

public data class DigitViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

/**
 * Defines the style for the currency symbol view in the balance.
 * This class allows you to customize the appearance of the currency symbol, including text size, color, and font.
 *
 * @property textSize The text size for the currency symbol, in SP (scaled pixels). Default is 18f.
 * @property textColorRes The resource ID for the text color of the currency symbol. Default is black.
 * @property fontResId The resource ID for the custom font to be applied to the currency symbol. Default is null, which means the default font will be used.
 */

public data class CurrencyViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

/**
 * Defines the style for the dot view that separates the integer and decimal parts of the balance.
 * This class allows you to customize the appearance of the dot separator, including text size, color, and font.
 *
 * @property textSize The text size for the dot separator, in SP (scaled pixels). Default is 18f.
 * @property textColorRes The resource ID for the text color of the dot separator. Default is black.
 * @property fontResId The resource ID for the custom font to be applied to the dot separator. Default is null, which means the default font will be used.
 */

public data class DotViewStyle(
    val textSize: Float = 18f,
    val textColorRes: Int = android.R.color.black,
    val fontResId: Int? = null
)

/**
 * Defines the style for the space (or grouping separator) view in the balance.
 * This class allows you to customize the width of the space between digit groups in the balance.
 *
 * @property spaceWidth The width of the space separator, in pixels. Default is 4.dp.
 */

public data class SpaceViewStyle(
    val spaceWidth: Int = 4.dp
)
