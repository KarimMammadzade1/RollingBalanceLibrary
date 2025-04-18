package r.team.rollingbalance.rollingbalanceview.component

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

/**
 * A custom `RecyclerView` that is designed to display the rolling balance items.
 * This view is intended for use within the library to handle custom layouts for balance display.
 *
 * @property context The context associated with this view, used for resource access and layout inflation.
 * @property attrs Optional attribute set passed from XML layout files to customize the view's behavior.
 * @property defStyleAttr Default style attributes for the view, used when the view is instantiated.
 */

// TODO: find a way to hide from XML
internal class RollingBalanceItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        setItemAlpha()
        setLayoutParameters()
        setLayoutManager()
        disableManualScroll()
        setSnapHelper()
    }

    private fun setItemAlpha(alpha: Float = 0F) {
        this.alpha = alpha
    }

    fun showItemWithAlphaAnim() {
        val animDuration =
            context.resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        this.animate().alpha(1F).setDuration(animDuration).start()

    }

    private fun setLayoutParameters() {
        layoutParams = ViewGroup.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
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
        speedFactor: Float = 600f,
        interpolator: Interpolator? = AccelerateInterpolator()
    ) {
        val linearLayoutManager = layoutManager as? LinearLayoutManager ?: return

        val smoothScroller = object : LinearSmoothScroller(context) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }

            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                val baseSpeed = speedFactor / displayMetrics.densityDpi

                interpolator?.let {
                    val interpolatedSpeed = it.getInterpolation(baseSpeed)
                    return interpolatedSpeed
                }

                return baseSpeed
            }
        }

        smoothScroller.targetPosition = position
        linearLayoutManager.startSmoothScroll(smoothScroller)
    }

    private fun RecyclerView.disableManualScroll() {
        this.setOnTouchListener { _, _ -> true }
    }

    fun adjustItemHeightWithChild() {
        post {
            val layoutManager = layoutManager as? LinearLayoutManager ?: return@post
            val firstItemView = layoutManager.findViewByPosition(0)
            val itemHeight = firstItemView?.height ?: return@post
            val itemWidth = firstItemView.width

            layoutParams.height = itemHeight
            layoutParams.width = itemWidth
            requestLayout()
        }
    }
}