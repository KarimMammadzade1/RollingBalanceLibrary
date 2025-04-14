package r.team.rollingbalancelibrary.rollingbalanceview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import r.team.rollingbalancelibrary.databinding.ListItemNumberBinding

class NumbersRVAdapter() : RecyclerView.Adapter<NumbersRVAdapter.NumberViewHolder>() {
    private val numbers = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    inner class NumberViewHolder(private val binding: ListItemNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Int) {
            binding.numberTextview.text = item.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NumberViewHolder(ListItemNumberBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount() = numbers.size

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bindItem(numbers.get(position))
    }

}