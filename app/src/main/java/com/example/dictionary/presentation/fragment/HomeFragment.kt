package com.example.dictionary.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dictionary.databinding.FragmentHomeBinding
import com.example.dictionary.domain.model.Word
import com.example.dictionary.presentation.adapter.AdapterWord
import com.example.dictionary.presentation.viewmodelfragment.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<HomeViewModel>()

    private var words: List<Word> = arrayListOf()
    private lateinit var adapterWord: AdapterWord

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getWords()
            adapterWord.notifyDataSetChanged()
        }

        adapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun adapter() {
        adapterWord = AdapterWord(words = words)
        binding.recyclerView.adapter = adapterWord
    }
}