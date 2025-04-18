package r.team.rollingbalancelibrary.rollingbalanceview.characters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import r.team.rollingbalancelibrary.rollingbalanceview.characters.Characters.indexOfChar
import r.team.rollingbalancelibrary.rollingbalanceview.provider.DigitViewStyle
import r.team.rollingbalancelibrary.rollingbalanceview.provider.provideDigitView

class CharactersRVAdapter(private val digitViewStyle: DigitViewStyle) :
    RecyclerView.Adapter<CharactersRVAdapter.NumberViewHolder>() {
    private val itemList = Characters.createCharactersList()

    inner class NumberViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(item: Char) {
            if (view is TextView) {
                view.text = item.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = createDefaultView(parent)
        return NumberViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bindItem(itemList[position])
    }

    private fun createDefaultView(parent: ViewGroup): View {
        return parent.context.provideDigitView(digitViewStyle)
    }

    fun getPositionForCharacter(input: Char): Int = itemList.indexOfChar(input)

}