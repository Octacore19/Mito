package com.octacoresoftwares.mito.ui.nearby

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.MikoApplication
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentNearbyBinding
import com.octacoresoftwares.mito.ui.chats.ChatsViewModel
import javax.inject.Inject

class NearbyFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<NearbyViewModel> { factory }
    private lateinit var binding: FragmentNearbyBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MikoApplication).appComponent.nearbyComponent().create().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_nearby, container, false)
        binding = FragmentNearbyBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}