package com.example.dictionary.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dictionary.databinding.FragmentTrainingBinding
import com.example.dictionary.presentation.viewmodelfragment.TrainingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrainingFragment : Fragment() {

    private var _binding: FragmentTrainingBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<TrainingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrainingBinding.inflate(inflater, container, false)

        animation()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun animation() {
        var state = false
        binding.buttonCard.setOnClickListener {
            state = if (!state) {
                binding.buttonCard.animate()
                    .rotationX(180f)
                    .setDuration(300)
                    .start()
                true
            } else {
                binding.buttonCard.animate()
                    .rotationX(0f)
                    .setDuration(300)
                    .start()
                false
            }
        }
    }
}