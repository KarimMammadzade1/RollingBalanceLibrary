package r.team.rollingbalance.rollingbalanceview.characters

internal object Characters {
    private const val CHAR_SPACE = ' '
    private const val CHAR_DOT = '.'
    private const val CHAR_COMMA = ','


    internal fun createCharactersList(
        includeSpace: Boolean = false,
        includeDot: Boolean = false,
        includeComma: Boolean = false
    ): List<Char> {
        return buildList {
            for (i in 0..9)
                add('0' + i)
            if (includeSpace)
                add(CHAR_SPACE)
            if (includeDot)
                add(CHAR_DOT)
            if (includeComma)
                add(CHAR_COMMA)
        }
    }

    internal fun List<Char>.indexOfChar(char: Char): Int {
        return when (char) {
            CHAR_SPACE,
            CHAR_DOT,
            CHAR_COMMA -> this.indexOf(char)

            else -> {
                if (char.isDigit())
                    char.toString().toInt()
                else {
                    throw Exception("exception thrown by Characters indexOfChar")
                }
            }
        }
    }

    internal fun Char.isSpace() = this == CHAR_SPACE
    internal fun Char.isDot() = this == CHAR_DOT
    internal fun Char.isComma() = this == CHAR_COMMA

    internal fun getDot() = CHAR_DOT
    internal fun getComma() = CHAR_COMMA
    internal fun getSpace() = CHAR_SPACE


}