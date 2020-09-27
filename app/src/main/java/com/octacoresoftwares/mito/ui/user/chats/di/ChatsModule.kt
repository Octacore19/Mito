package com.octacoresoftwares.mito.ui.user.chats.di

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.mito.di.ViewModelKey
import com.octacoresoftwares.mito.ui.user.chats.ChatsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ChatsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatsViewModel::class)
    abstract fun bindChatViewModel(viewModel: ChatsViewModel): ViewModel
}