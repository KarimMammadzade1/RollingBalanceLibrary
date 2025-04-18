package r.team.rollingbalance.rollingbalanceview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import r.team.rollingbalance.rollingbalanceview.characters.Characters.isDot
import r.team.rollingbalance.rollingbalanceview.characters.Characters.isSpace
import r.team.rollingbalance.rollingbalanceview.characters.CharactersRVAdapter
import r.team.rollingbalance.rollingbalanceview.component.RollingBalanceItemView
import r.team.rollingbalance.rollingbalanceview.provider.CurrencyViewStyle
import r.team.rollingbalance.rollingbalanceview.provider.DigitViewStyle
import r.team.rollingbalance.rollingbalanceview.provider.DotViewStyle
import r.team.rollingbalance.rollingbalanceview.provider.SpaceViewStyle
import r.team.rollingbalance.rollingbalanceview.provider.provideCurrencyView
import r.team.rollingbalance.rollingbalanceview.provider.provideDotView
import r.team.rollingbalance.rollingbalanceview.utils.dp
import java.text.DecimalFormat

/**
 * A custom `View` designed to display a rolling balance with the option to format
 * and customize its appearance. This view can be used to represent balance information
 * in various financial or numerical applications.
 *
 * The view automatically handles user input, formatting, and display of the balance.
 * It is highly customizable through XML attributes and programmatic configuration.
 */

public class RollingBalanceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var currentBalance: Double? = null
    private val isFirstSet get() = currentBalance == null

    private val recyclerViews = mutableListOf<RollingBalanceItemView>()
    private val currencyViews = mutableListOf<TextView>()
    private val spaceViews = mutableListOf<Space>()
    private val dotViews = mutableListOf<TextView>()

    private var formatter: DecimalFormat = DecimalFormat()

    private var digitViewStyle: DigitViewStyle = DigitViewStyle()
    private var currencyViewStyle: CurrencyViewStyle = CurrencyViewStyle()
    private var dotViewStyle: DotViewStyle = DotViewStyle()
    private var spaceViewStyle: SpaceViewStyle = SpaceViewStyle()


    init {
        setViewOrientation()
    }

    private fun setViewOrientation() {
        this.orientation = HORIZONTAL
    }

    /**
     * Sets a custom `DecimalFormat` formatter to control how the balance is displayed.
     * This allows you to define how the balance value will be formatted (e.g., decimal places,
     * grouping separators, etc.) before it's shown in the view.
     *
     * @param formatter The `DecimalFormat` to use for formatting the balance.
     */

    public fun setFormatter(formatter: DecimalFormat) {
        this.formatter = formatter
    }

    /**
     * Sets the style for the digit views of the balance.
     * This allows customization of how digits in the balance are displayed, such as their size,
     * color, or font style.
     *
     * @param viewStyle The `DigitViewStyle` that defines the appearance of the digit views.
     */

    public fun setDigitViewStyle(viewStyle: DigitViewStyle) {
        digitViewStyle = viewStyle
    }

    /**
     * Sets the style for the currency symbol view.
     * This controls how the currency symbol (e.g., `$`, `€`) is displayed, including
     * its size, color, and position relative to the balance.
     *
     * @param viewStyle The `CurrencyViewStyle` that defines the appearance of the currency symbol.
     */

    public fun setCurrencyViewStyle(viewStyle: CurrencyViewStyle) {
        currencyViewStyle = viewStyle
    }

    /**
     * Sets the style for the dot view that separates the decimal part of the balance.
     * This controls the appearance of the dot (e.g., `.`) used to separate the integer part
     * from the decimal part of the balance value.
     *
     * @param viewStyle The `DotViewStyle` that defines the appearance of the dot view.
     */

    public fun setDotViewStyle(viewStyle: DotViewStyle) {
        dotViewStyle = viewStyle
    }

    /**
     * Sets the style for the space view that separates the groups of digits in the balance.
     * This controls the appearance of the space (or grouping separator) used to separate groups
     * of digits, such as `1 000` for thousands.
     *
     * @param viewStyle The `SpaceViewStyle` that defines the appearance of the space view.
     */

    public fun setSpaceViewStyle(viewStyle: SpaceViewStyle) {
        spaceViewStyle = viewStyle
    }

    /**
     * Sets the balance value to be displayed in the view. This method updates the displayed
     * balance, and will reset and re-initialize the view if the new balance or currency is
     * different from the current settings.
     *
     * @param newBalance The new balance value to be displayed.
     * @param currency An optional currency symbol to be used with the balance. If `null`, the
     * default currency symbol will be used.
     */

    public fun setBalance(newBalance: Double, currency: String? = null) {
        if (isFirstSet) {
            initBalanceView(newBalance, currency)
        } else {
            if (isBalanceFieldsDiffer(newBalance, currency)) {
                resetViews()
                currentBalance = null
                initBalanceView(newBalance, currency)
            } else {
                setBalanceByDouble(newBalance)
            }
        }
    }

    private fun isBalanceFieldsDiffer(newBalance: Double, currency: String? = null): Boolean {
        handleCurrencyChangeIfRequired(currency)
        val formattedNewBalance = formatter.format(newBalance)
        val formattedBalance = formatter.format(currentBalance)
        return formattedNewBalance != formattedBalance

    }

    private fun handleCurrencyChangeIfRequired(currency: String?) {
        val currentCurrencyView = currencyViews.firstOrNull() ?: return
        with(currentCurrencyView) {
            if (text != currency)
                text = currency
        }
    }

    private fun initBalanceView(
        balance: Double,
        currency: String? = null
    ) {
        initBalanceFields(balance)
        currency?.let {
            initCurrencyField(currency)
        }

    }


    private fun initBalanceFields(balance: Double) {
        val formattedBalance = formatter.format(balance)
        for (char in formattedBalance) {
            if (char.isDigit())
                initDigitField()

            if (char.isSpace())
                initSpaceField()
            if (char.isDot())
                initDotField()
        }

        setBalanceByDouble(balance)
    }

    private fun initDigitField() {
        val recyclerView = RollingBalanceItemView(context)
        val charactersAdapter = CharactersRVAdapter(digitViewStyle)
        recyclerView.adapter = charactersAdapter
        recyclerView.adjustItemHeightWithChild()
        recyclerView.showItemWithAlphaAnim()
        this.addView(recyclerView)
        recyclerViews.add(recyclerView)
    }

    private fun initSpaceField() {
        val spaceView = Space(context).apply {
            layoutParams = ViewGroup.LayoutParams(spaceViewStyle.spaceWidth, 0.dp)
        }
        this.addView(spaceView)
        spaceViews.add(spaceView)
    }

    private fun initDotField() {
        val dotView = context.provideDotView(dotViewStyle)

        if (dotView is TextView) {
            this.addView(dotView)
            dotViews.add(dotView)
        } else {
            throw Exception("Custom dot view is not a TextView - RollingBalanceView")
        }
    }

    private fun initCurrencyField(currency: String) {
        val currencyView = context.provideCurrencyView(currencyViewStyle, currency)

        if (currencyView is TextView) {
            this.addView(currencyView)
            currencyViews.add(currencyView)
        } else {
            throw Exception("Custom currency view is not a TextView - RollingBalanceView")
        }
    }


    private fun setBalanceByDouble(balance: Double) {
        val formattedBalance = formatter.format(balance)
        val balanceChars = formattedBalance.toCharArray().filter { it.isDigit() }

        for (index in balanceChars.indices) {
            val char = balanceChars[index]
            if (!char.isDigit())
                continue
            recyclerViews.getOrNull(index)?.let { recyclerView ->
                val pos = recyclerView.positionOfChar(char)
                recyclerView.post {
                    recyclerView.slowSmoothScrollTo(pos)
                }
            }
                ?: throw Exception("RollingBalanceView setFormattedBalance RV is null on index $index")
        }
        currentBalance = balance
    }

    private fun RollingBalanceItemView.positionOfChar(char: Char): Int {
        return (this.adapter as CharactersRVAdapter).getPositionForCharacter(char)
    }

    private fun resetViews() {
        recyclerViews.clear()
        currencyViews.clear()
        spaceViews.clear()
        dotViews.clear()
        removeAllViews()
    }
}