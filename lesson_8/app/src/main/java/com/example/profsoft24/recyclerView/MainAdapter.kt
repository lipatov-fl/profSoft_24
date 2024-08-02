package com.example.profsoft24.recyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.profsoft24.common.AdapterItem
import com.example.profsoft24.models.TextWithBackgroundItem
import com.example.profsoft24.models.TextWithoutBackgroundItem

class MainAdapter : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        private const val TEXT_WITHOUT_BG_ITEM = 0
        private const val TEXT_WITH_BG_ITEM = 1
    }

    private val items = mutableListOf<AdapterItem>()
    private var onItemClick: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TEXT_WITHOUT_BG_ITEM -> TextWithoutBackgroundViewHolder(parent)
            TEXT_WITH_BG_ITEM -> TextWithBackgroundViewHolder(parent)
            else -> throw Exception("Invalid view type")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TEXT_WITHOUT_BG_ITEM -> (holder as TextWithoutBackgroundViewHolder).bind(items[position] as TextWithoutBackgroundItem)
            TEXT_WITH_BG_ITEM -> (holder as TextWithBackgroundViewHolder).bind(items[position] as TextWithBackgroundItem)
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is TextWithoutBackgroundItem) TEXT_WITHOUT_BG_ITEM else TEXT_WITH_BG_ITEM
    }

    fun addItem(item: AdapterItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun setItems(items: List<AdapterItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position in 0 until items.size) {
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
        }
    }
}

