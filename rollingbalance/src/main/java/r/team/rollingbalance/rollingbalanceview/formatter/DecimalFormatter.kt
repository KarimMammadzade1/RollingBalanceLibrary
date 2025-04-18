package r.team.rollingbalance.rollingbalanceview.formatter

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

/**
 * A utility object for creating custom `DecimalFormat` instances.
 * Provides helper functions to create decimal formatters for balances and other numeric values.
 * It allows for customization of the pattern, grouping separator, and decimal separator.
 *
 * The default pattern for balance formatting is `#,###.##`, with a space as the grouping separator
 * and a period (`.`) as the decimal separator.
 */

public object DecimalFormatter {
    private const val PATTERN_BALANCE = "#,###.##"
    private const val PATTERN_SYMBOL_GROUPING_SEPARATOR = ' '
    private const val PATTERN_SYMBOL_DECIMAL_SEPARATOR = '.'

    /**
     * Creates a `DecimalFormat` for balance values with customizable pattern, grouping separator, and decimal separator.
     *
     * @param pattern The pattern for formatting the balance (default is `#,###.##`).
     * @param groupingSeparator The character to use for grouping digits (default is a space).
     * @param decimalSeparator The character to use as the decimal separator (default is a period).
     * @return A `DecimalFormat` instance configured with the specified pattern and symbols.
     */

    fun createBalanceDecimalFormatter(
        pattern: String = PATTERN_BALANCE,
        groupingSeparator: Char = PATTERN_SYMBOL_GROUPING_SEPARATOR,
        decimalSeparator: Char = PATTERN_SYMBOL_DECIMAL_SEPARATOR
    ) = DecimalFormat(pattern, DecimalFormatSymbols().apply {
        this.groupingSeparator = groupingSeparator
        this.decimalSeparator = decimalSeparator
    })

    /**
     * Creates a default `DecimalFormat` instance with no pattern applied.
     * This can be used for general-purpose formatting without any custom symbols or patterns.
     *
     * @return A `DecimalFormat` instance with default formatting settings.
     */

    fun createDecimalFormatter() = DecimalFormat()


}