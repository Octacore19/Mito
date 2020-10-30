package com.octacoresoftwares.mito.screens.user.chats

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.octacoresoftwares.mito.R
import com.octacoresoftwares.mito.databinding.FragmentChatsBinding
import com.octacoresoftwares.mito.screens.container.ContainerFragment
import javax.inject.Inject

class ChatsFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<ChatsViewModel> { factory }
    private lateinit var binding: FragmentChatsBinding

    private val parentFragment by lazy {
        requireParentFragment().requireParentFragment() as ContainerFragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragment.userManager.userComponent?.chatComponent()?.create()?.inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        binding = FragmentChatsBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}