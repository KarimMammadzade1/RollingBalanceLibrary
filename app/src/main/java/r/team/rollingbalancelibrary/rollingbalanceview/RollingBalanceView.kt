package r.team.rollingbalancelibrary.rollingbalanceview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class RollingBalanceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    val recyclerViews = mutableListOf<RollingBalanceItemView>()

    init {
        setViewOrientation()
    }

    private fun setViewOrientation() {
        this.orientation = HORIZONTAL
    }

    fun initBalanceView(fieldSize: Int) {
        for (i in 0 until fieldSize) {
            val recyclerView = RollingBalanceItemView(context)
            recyclerView.adapter = NumbersRVAdapter()
            this.addView(recyclerView)
            recyclerViews.add(recyclerView)
        }
    }

    fun setBalance(balance: String) {
        for (index in 0 until balance.count()) {
            val number = balance.get(index).toString().toInt()
            val rv = recyclerViews.get(index)
            rv.slowSmoothScrollTo(number)
        }

    }
}