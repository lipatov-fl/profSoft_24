package com.example.profsoft24.viewPager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.profsoft24.R
import com.example.profsoft24.databinding.ViewPageItemBinding

class ViewPagerViewHolder(parent: ViewGroup) : ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.view_page_item, parent, false
    )
) {

    private val binding = ViewPageItemBinding.bind(itemView)

    fun bind(text: String) = with(binding) {
        viewPagerTextView.text = text
    }
}