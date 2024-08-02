package com.example.profsoft24.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.profsoft24.R
import com.example.profsoft24.databinding.TxtWithOutBgItemBinding
import com.example.profsoft24.models.TextWithoutBackgroundItem

class TextWithoutBackgroundViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.txt_with_out_bg_item, parent, false)
) {
    private val binding = TxtWithOutBgItemBinding.bind(itemView)
    fun bind(item: TextWithoutBackgroundItem) = with(binding) {
        textViewSmall.text = item.text
    }
}