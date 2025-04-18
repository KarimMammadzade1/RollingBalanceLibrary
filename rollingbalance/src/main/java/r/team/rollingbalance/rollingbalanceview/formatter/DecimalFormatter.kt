package r.team.rollingbalance.rollingbalanceview.formatter

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

public object DecimalFormatter {
    private const val PATTERN_BALANCE = "#,###.##"
    private const val PATTERN_SYMBOL_GROUPING_SEPARATOR = ' '
    private const val PATTERN_SYMBOL_DECIMAL_SEPARATOR = '.'

    fun createBalanceDecimalFormatter(
        pattern: String = PATTERN_BALANCE,
        groupingSeparator: Char = PATTERN_SYMBOL_GROUPING_SEPARATOR,
        decimalSeparator: Char = PATTERN_SYMBOL_DECIMAL_SEPARATOR
    ) = DecimalFormat(pattern, DecimalFormatSymbols().apply {
        this.groupingSeparator = groupingSeparator
        this.decimalSeparator = decimalSeparator
    })

    fun createDecimalFormatter() = DecimalFormat()


}