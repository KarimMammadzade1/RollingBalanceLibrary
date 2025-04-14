package r.team.rollingbalancelibrary

import android.view.animation.Interpolator
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import r.team.rollingbalancelibrary.rollingbalanceview.NumbersRVAdapter
import r.team.rollingbalancelibrary.rollingbalanceview.RollingBalanceView

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var rollingBalanceView: RollingBalanceView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rootLayout = findViewById(R.id.root_layout)
        rollingBalanceView = findViewById(R.id.rolling_balance_view)
        initBalanceRoller()
    }

    private fun initBalanceRoller() {
        val balance="9999"
        rollingBalanceView.initBalanceView(balance.count())

        rollingBalanceView.setBalance(balance)


    }


//        val recyclerView1 = createRecyclerView()
//        rootLayout.addView(recyclerView1)
//        recyclerView1.adapter = NumbersRVAdapter()
//
//        val recyclerView2 = createRecyclerView()
//        rootLayout.addView(recyclerView2)
//        recyclerView2.adapter = NumbersRVAdapter()
//
//        val recyclerView3 = createRecyclerView()
//        rootLayout.addView(recyclerView3)
//        recyclerView3.adapter = NumbersRVAdapter()
//
//        val recyclerView4 = createRecyclerView()
//        rootLayout.addView(recyclerView4)
//        recyclerView4.adapter = NumbersRVAdapter()
//
//        val recyclerView5 = createRecyclerView()
//        rootLayout.addView(recyclerView5)
//        recyclerView5.adapter = NumbersRVAdapter()
//
//        val recyclerView6 = createRecyclerView()
//        rootLayout.addView(recyclerView6)
//        recyclerView6.adapter = NumbersRVAdapter()
//
//        val recyclerView7 = createRecyclerView()
//        rootLayout.addView(recyclerView7)
//        recyclerView7.adapter = NumbersRVAdapter()
//
//        val recyclerView8 = createRecyclerView()
//        rootLayout.addView(recyclerView8)
//        recyclerView8.adapter = NumbersRVAdapter()
//
//        recyclerView1.postDelayed(400, {
//            recyclerView1.slowSmoothScrollTo(1)
//        })
//        recyclerView2.postDelayed(400, {
//            recyclerView2.slowSmoothScrollTo(2)
//        })
//        recyclerView3.postDelayed(400, {
//            recyclerView3.slowSmoothScrollTo(3)
//        })
//        recyclerView4.postDelayed(400, {
//            recyclerView4.slowSmoothScrollTo(4)
//        })
//        recyclerView5.postDelayed(400, {
//            recyclerView5.slowSmoothScrollTo(5)
//        })
//        recyclerView6.postDelayed(400, {
//            recyclerView6.slowSmoothScrollTo(6)
//        })
//        recyclerView7.postDelayed(400, {
//            recyclerView7.slowSmoothScrollTo(7)
//        })
//        recyclerView8.postDelayed(400, {
//            recyclerView8.slowSmoothScrollTo(8)
//        })


}