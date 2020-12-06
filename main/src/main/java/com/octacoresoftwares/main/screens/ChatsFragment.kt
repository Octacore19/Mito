package com.octacoresoftwares.main.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.octacoresoftwares.main.R
import com.octacoresoftwares.main.databinding.FragmentChatsBinding

class ChatsFragment: Fragment() {

    private lateinit var binding: FragmentChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        binding = FragmentChatsBinding.bind(view)
        return binding.root
    }
}