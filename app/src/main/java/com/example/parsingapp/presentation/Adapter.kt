package com.example.parsingapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingapp.R
import com.example.parsingapp.data.models.ParseModel

class Adapter(
    private var contacts: List<ParseModel>,
) : RecyclerView.Adapter<Adapter.BaseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return BaseHolder(view)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(string: ParseModel) {
            val number = itemView.findViewById<TextView>(R.id.textView)
            if (string.out) {
                number.text = OUT_OF_RANGE
            } else {
                val markImage = itemView.findViewById<ImageView>(R.id.mark)
                if (string.mark) {
                    markImage.visibility = VISIBLE
                }
                // since the requirements clearly state "The "item value" must be matched against 6 titles",
                // based on this requirement, it was decided to discard all variations of bits in which
                // there are more than six items, the number of examples also does not make it possible
                // to make a more accurate assumption
                val item = if (string.item > MAX_ITEM_LEVEL || string.item < MIN_ITEM_LEVEL) {
                    ITEM_OUT_OF_RANGE
                } else "$ITEM ${string.item}"
                number.text = "$item $SECTION${string.section}"
            }
        }
    }

    private companion object {
        const val OUT_OF_RANGE = "OUT OF RANGE"
        const val ITEM = "ITEM"
        const val SECTION = "SECTION"
        const val ITEM_OUT_OF_RANGE = "item>6"
        const val MAX_ITEM_LEVEL = 6
        const val MIN_ITEM_LEVEL = 1
    }
}