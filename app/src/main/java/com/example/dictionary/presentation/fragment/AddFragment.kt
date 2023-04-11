package com.example.dictionary.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dictionary.R
import com.example.dictionary.databinding.FragmentAddBinding
import com.example.dictionary.domain.model.Word
import com.example.dictionary.presentation.activity.MainActivity
import com.example.dictionary.presentation.viewmodelfragment.AddViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<AddViewModel>()

    private lateinit var words: List<Word>
    var type = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        spinner()
        addWord()

        CoroutineScope(Dispatchers.Default).launch {
            viewModel.getWords()
        }

        viewModel.words.observe(viewLifecycleOwner) {
            words = it
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addWord(word: Word) {
        viewModel.addWord(word = word)
    }

    private fun spinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.parts_of_speech_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerRussian.adapter = adapter
        }
    }

    private fun addWord() {
        binding.addButton.setOnClickListener {
            if (binding.editTextEnglish.text.isNotEmpty()) {
                if (binding.editTextRussian.text.isNotEmpty()) {
                    seeWord(
                        Word(
                            english = binding.editTextEnglish.text.toString().trim(),
                            russian = binding.editTextRussian.text.toString()
                                .trim() + binding.spinnerRussian.selectedItem.toString().trim()
                        )
                    )
                    if (!type) {
                        addWord(
                            Word(
                                english = binding.editTextEnglish.text.toString().trim(),
                                russian = binding.editTextRussian.text.toString()
                                    .trim() + binding.spinnerRussian.selectedItem.toString().trim()
                            )
                        )
                        (activity as MainActivity).navigateAction(R.id.menu1)
                    } else {
                        Toast.makeText(requireContext(), "Такое слово уже есть", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun seeWord(word: Word) {
        var i = 0
        while (i < words.size) {
            type = word.russian == words[i].russian && word.english == words[i].english
            i++
        }
    }
}