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