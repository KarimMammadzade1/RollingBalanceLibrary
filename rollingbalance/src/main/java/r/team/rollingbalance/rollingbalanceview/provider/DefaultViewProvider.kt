package r.team.rollingbalance.rollingbalanceview.provider

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import r.team.rollingbalance.rollingbalanceview.characters.Characters


private const val DEFAULT_FONT_FAMILY = "serif"

/**
 * Provides a customized `TextView` to display the dot separator used between the integer and decimal parts
 * of the balance. This allows you to define the style (e.g., font size, color, font) of the dot view.
 *
 * @param viewStyle The `DotViewStyle` defining the appearance of the dot separator.
 * @return A `TextView` configured with the specified dot style.
 */

public fun Context.provideDotView(viewStyle: DotViewStyle) =
    TextView(this).apply {
        text = Characters.getDot().toString()
        gravity = Gravity.CENTER
        this.typeface = when {
            viewStyle.fontResId != null -> ResourcesCompat.getFont(
                this@provideDotView,
                viewStyle.fontResId
            )

            else -> {
                Typeface.create(DEFAULT_FONT_FAMILY, Typeface.BOLD)
            }
        }
        setTextColor(ContextCompat.getColor(this@provideDotView, viewStyle.textColorRes))
        setTextSize(TypedValue.COMPLEX_UNIT_SP, viewStyle.textSize)
    }

/**
 * Provides a customized `TextView` to display the currency symbol next to the balance.
 * This allows you to define the style (e.g., font size, color, font) of the currency symbol.
 *
 * @param viewStyle The `CurrencyViewStyle` defining the appearance of the currency symbol.
 * @param currency The currency symbol to display (e.g., "$", "€").
 * @return A `TextView` configured with the specified currency style and symbol.
 */

public fun Context.provideCurrencyView(viewStyle: CurrencyViewStyle, currency: String) =
    TextView(this).apply {
        text = currency
        gravity = Gravity.CENTER
        this.typeface = when {
            viewStyle.fontResId != null -> ResourcesCompat.getFont(
                this@provideCurrencyView,
                viewStyle.fontResId
            )

            else -> {
                Typeface.create(DEFAULT_FONT_FAMILY, Typeface.BOLD)
            }
        }
        setTextColor(ContextCompat.getColor(this@provideCurrencyView, viewStyle.textColorRes))
        setTextSize(TypedValue.COMPLEX_UNIT_SP, viewStyle.textSize)
    }

/**
 * Provides a customized `TextView` to display a digit in the balance. This allows you to define the style
 * (e.g., font size, color, font) of the digit view.
 *
 * @param viewStyle The `DigitViewStyle` defining the appearance of the digit view.
 * @return A `TextView` configured with the specified digit style.
 */

public fun Context.provideDigitView(viewStyle: DigitViewStyle) = TextView(this).apply {
    gravity = Gravity.CENTER

    this.typeface = when {
        viewStyle.fontResId != null -> ResourcesCompat.getFont(
            this@provideDigitView,
            viewStyle.fontResId
        )

        else -> {
            Typeface.create(DEFAULT_FONT_FAMILY, Typeface.BOLD)
        }
    }

    setTextColor(ContextCompat.getColor(this@provideDigitView, viewStyle.textColorRes))
    setTextSize(TypedValue.COMPLEX_UNIT_SP, viewStyle.textSize)
}