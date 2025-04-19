# RollingBalance Library

A lightweight customizable rolling balance animation for Android 🎯


## Installation

In your module-level build.gradle
`implementation("com.github.KarimMammadzade1:RollingBalanceLibrary:v${LATEST_VERSION}")`
## Usage

### Add component to your layout
`  <r.team.rollingbalance.rollingbalanceview.RollingBalanceView
      android:id="@+id/rolling_balance_view"
      android:layout_width="match_parent"
      android:layout_height="match_parent" />`
### Then manage it programmatically
`    val balanceView = findViewById<RollingBalanceView>(R.id.balanceView)
    balanceView.setScrollSpeedPercent(50)
    balanceView.setScrollingSpeed(RollingSpeed.MEDIUM)
    balanceView.setBalance(1234.56,'CURRENCY')`

## Specification

You can refer to the KDoc documents inside library


## License

The RollingBalanceLibrary project is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).