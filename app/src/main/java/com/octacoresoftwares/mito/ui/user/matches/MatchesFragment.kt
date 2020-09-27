package com.octacoresoftwares.mito.ui.user.matches

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.MitoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentMatchesBinding
import javax.inject.Inject

class MatchesFragment : Fragment() {

    /*@Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<MatchesViewModel> { factory }*/
    private lateinit var binding: FragmentMatchesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        (requireActivity().application as MitoApplication).appComponent.matchesComponent().create().inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_matches, container, false)
        binding = FragmentMatchesBinding.bind(view)
//        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}