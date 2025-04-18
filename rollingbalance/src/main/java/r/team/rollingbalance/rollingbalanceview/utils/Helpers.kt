package r.team.rollingbalance.rollingbalanceview.utils

import android.content.res.Resources

public val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()