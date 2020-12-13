package com.octacoresoftwares.chats.di.modules

import androidx.lifecycle.ViewModel
import com.octacoresoftwares.chats.viewmodels.ChatsLandingViewModel
import com.octacoresoftwares.core.di.keys.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ChatLandingModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatsLandingViewModel::class)
    abstract fun bindsChatLandingViewModel(viewModel: ChatsLandingViewModel): ViewModel
}