package com.poly.test.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.poly.test.R
import com.poly.test.activity.IntroSlide
import com.poly.test.viewModel.IntroViewModel

class IntroSlideAdapter(var viewModel: IntroViewModel) :
    RecyclerView.Adapter<IntroSlideAdapter.IntroSlideViewholder>() {

    var listItem = listOf<IntroSlide>()

    inner class IntroSlideViewholder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.findViewById<TextView>(R.id.tv_title)
        var image = view.findViewById<ImageView>(R.id.iv_image)
        var btnNext = view.findViewById<Button>(R.id.btn_next)
        var btnSkip= view.findViewById<Button>(R.id.btn_skip)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewholder {
        var holder = LayoutInflater.from(parent.context).inflate(R.layout.intro_row, parent, false)
        return IntroSlideViewholder(holder)
    }

    override fun onBindViewHolder(holder: IntroSlideViewholder, position: Int) {
        var items = listItem[position]

        var btnNext = holder.btnNext
        val textTitle = holder.textTitle
        val image = holder.image



        textTitle.text = items.title
        image.setImageResource(items.icon)

        if (position < itemCount ) {
            btnNext.isEnabled = true
            btnNext.setOnClickListener {
                viewModel.nextPage.value = position + 1
            }
            

        }else{
            btnNext.isEnabled = true



        }

    }

    fun replaceItems(items: List<IntroSlide>) {
        this.listItem = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}