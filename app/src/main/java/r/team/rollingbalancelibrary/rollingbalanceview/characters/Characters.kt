package r.team.rollingbalancelibrary.rollingbalanceview.characters

object Characters {
    private const val CHAR_SPACE = ' '
    private const val CHAR_DOT = '.'
    private const val CHAR_COMMA = ','


    fun createCharactersList(
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

    fun List<Char>.indexOfChar(char: Char): Int {
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

    fun Char.isSpace() = this == CHAR_SPACE
    fun Char.isDot() = this == CHAR_DOT
    fun Char.isComma() = this == CHAR_COMMA

    fun getDot() = CHAR_DOT
    fun getComma() = CHAR_COMMA
    fun getSpace() = CHAR_SPACE


}