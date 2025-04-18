package r.team.rollingbalancelibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import r.team.rollingbalance.rollingbalanceview.RollingBalanceView

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var rollingBalanceView: RollingBalanceView
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Roll
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rootLayout = findViewById(R.id.root_layout)
        rollingBalanceView = findViewById(R.id.rolling_balance_view)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.edittext)
        initBalanceRoller()
        handleClickListener()
    }

    private fun initBalanceRoller() {
        rollingBalanceView.setFormatter(r.team.rollingbalance.rollingbalanceview.formatter.DecimalFormatter.createBalanceDecimalFormatter())
    }

    private fun handleClickListener() {
        button.setOnClickListener {
            val newAmount = editText.text.toString().toDouble()
            rollingBalanceView.setBalance(newAmount, "$")
        }

    }
}