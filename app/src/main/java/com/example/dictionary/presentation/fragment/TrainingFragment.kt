package com.example.dictionary.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dictionary.databinding.FragmentTrainingBinding
import com.example.dictionary.domain.model.Word
import com.example.dictionary.presentation.viewmodelfragment.TrainingViewModel
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate


class TrainingFragment : Fragment() {

    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<TrainingViewModel>()

    private lateinit var words: List<Word>
    private var state = false
    private var number = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)

        animation()

        CoroutineScope(Dispatchers.IO).launch {
            if (LocalDate.now().dayOfWeek.value == 1) {
                getWords()
            } else {
                getWordsMin()
            }
        }

        viewModel.words.observe(viewLifecycleOwner) {
            words = it
            setTextButton()
        }

        binding.buttonKnow.setOnClickListener {
            MainScope().launch {
                withContext(Dispatchers.Default) { knowWord() }
                withContext(Dispatchers.Default) { number++ }
                setTextButton()
            }
        }
        binding.buttonNotKnow.setOnClickListener {
            MainScope().launch {
                withContext(Dispatchers.Default) { notKnowWord() }
                withContext(Dispatchers.Default) { number++ }
                setTextButton()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun animation() {
        binding.buttonCard.setOnClickListener {
            if (!state) {
                binding.buttonCard.animate()
                    .rotationX(180f)
                    .setDuration(300)
                    .start()
                state = true
                setTextButton()
            } else {
                binding.buttonCard.animate()
                    .rotationX(0f)
                    .setDuration(300)
                    .start()
                state = false
                setTextButton()
            }
        }
    }

    private fun getWordsMin() {
        viewModel.getWordsMin()
    }

    private fun getWords() {
        viewModel.getWords()
    }

    private fun updateDay(word: Word) {
        viewModel.updateDay(word = word)
    }

    private fun setTextButton() {
        if (words.size > number) {
            if (!state) {
                binding.textCard.text = words[number].russian
            } else {
                binding.textCard.text = words[number].english
            }
        } else {
            Toast.makeText(requireContext(), "Больше нет", Toast.LENGTH_LONG).show()
            binding.buttonCard.isClickable = false
        }
    }

    private fun knowWord() {
        if (words.size > number) {
            updateDay(
                word = Word(
                    id = words[number].id,
                    english = words[number].english,
                    russian = words[number].russian,
                    daysWithoutMistakes = words[number].daysWithoutMistakes + 1
                )
            )
        }
    }

    private fun notKnowWord() {
        if (words.size > number) {
            updateDay(
                word = Word(
                    id = words[number].id,
                    english = words[number].english,
                    russian = words[number].russian,
                    daysWithoutMistakes = 0
                )
            )
        }
    }
}