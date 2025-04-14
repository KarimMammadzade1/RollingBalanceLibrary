package r.team.rollingbalancelibrary.rollingbalanceview

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Interpolator
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class RollingBalanceItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        setLayoutParameters()
        setLayoutManager()
        disableManualScroll()
        setSnapHelper()
    }

    private fun setLayoutParameters() {
        layoutParams = ViewGroup.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            60
        )
    }

    private fun setLayoutManager() {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setSnapHelper() {
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(this)
    }


    fun slowSmoothScrollTo(
        position: Int,
        speedFactor: Float = 1000f,
        interpolator: Interpolator? = AccelerateInterpolator()
    ) {
        val linearLayoutManager = layoutManager as? LinearLayoutManager ?: return

        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                // Base speed per pixel
                val baseSpeed = speedFactor / displayMetrics.densityDpi

                // If an interpolator is provided, adjust the speed per pixel based on the interpolation.
                interpolator?.let {
                    // Apply the interpolator based on the scroll progress (0 to 1)
                    val interpolatedSpeed = it.getInterpolation(baseSpeed)
                    return interpolatedSpeed
                }

                // Default to base speed if no interpolator is provided
                return baseSpeed
            }
        }

        smoothScroller.targetPosition = position
        linearLayoutManager.startSmoothScroll(smoothScroller)
    }

    private fun RecyclerView.disableManualScroll() {
        this.setOnTouchListener { _, _ -> true }  // This consumes the touch event and prevents scrolling
    }
}
