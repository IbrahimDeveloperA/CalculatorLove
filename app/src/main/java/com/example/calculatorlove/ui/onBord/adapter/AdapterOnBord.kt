package com.example.calculatorlove.ui.onBord.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.calculatorlove.R
import com.example.calculatorlove.data.model.OnBord
import com.example.calculatorlove.databinding.ItemOnBordBinding

class AdapterOnBord(val onClick: () -> Unit) : Adapter<AdapterOnBord.ViewHolderOnBord>() {

    private val list = arrayListOf(
        OnBord(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.love
        ),
        OnBord(
            "Cherishing love",
            "It is now no longer possible for you to cherish love",
            R.raw.love_and_kind
        ),
        OnBord(
            "Have a break up?",
            "We have made the correction for you don't worry. Maybe someone is waiting for you",
            R.raw.heart_love_animation
        ),
        OnBord(
            "It's Funs and Many more", "",
            R.raw.book_lover
        )
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOnBord {
        return ViewHolderOnBord(
            ItemOnBordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolderOnBord, position: Int) {
        holder.onBind(list[position])
    }

    inner class ViewHolderOnBord(private val binding: ItemOnBordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(onBord: OnBord) {
            binding.tvTitle.text = onBord.title
            binding.tvDesc.text = onBord.desc
            binding.btnNext.setOnClickListener {
                onClick()
            }
            binding.btnNext.isVisible = adapterPosition == list.lastIndex
        }
    }
}