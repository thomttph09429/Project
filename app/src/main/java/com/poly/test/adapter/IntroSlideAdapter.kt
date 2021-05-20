package com.poly.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poly.test.R
import com.poly.test.activity.IntroSlide

class IntroSlideAdapter(var listIntroSlide: List<IntroSlide>) :
    RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewholder>() {


    inner class IntroSlideViewholder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.tv_title)
        var image = view.findViewById<ImageView>(R.id.iv_image)
        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            image.setImageResource(introSlide.icon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewholder {
        var holder = LayoutInflater.from(parent.context).inflate(R.layout.intro_row, parent, false)
        return IntroSlideViewholder(holder)
    }

    override fun onBindViewHolder(holder: IntroSlideViewholder, position: Int) {

        holder.bind(listIntroSlide[position])
    }

    override fun getItemCount(): Int {
        return listIntroSlide.size
    }
}