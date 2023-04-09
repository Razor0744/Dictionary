package com.example.dictionary.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.RecyclerViewWordBinding
import com.example.dictionary.domain.model.Word

class AdapterWord(private val words: List<Word>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolderWord(private val binding: RecyclerViewWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindWord(word: Word) {
            binding.english.text = word.english
            binding.russian.text = word.russian
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            RecyclerViewWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderWord(binding)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderWord).bindWord(word = words[position])
    }
}