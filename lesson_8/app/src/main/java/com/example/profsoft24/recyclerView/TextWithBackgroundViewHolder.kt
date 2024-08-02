package com.example.profsoft24.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.profsoft24.R
import com.example.profsoft24.databinding.TxtWithBgItemBinding
import com.example.profsoft24.models.TextWithBackgroundItem

class TextWithBackgroundViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.txt_with_bg_item, parent, false)
) {
    private val binding = TxtWithBgItemBinding.bind(itemView)
    fun bind(item: TextWithBackgroundItem) = with(binding) {
        textViewBig.text = item.text
    }
}