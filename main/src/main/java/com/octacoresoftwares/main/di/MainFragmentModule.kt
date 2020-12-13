package com.octacoresoftwares.main.di

import com.octacoresoftwares.chats.di.ChatsFragmentModule
import com.octacoresoftwares.main.MainFragment
import com.octacoresoftwares.matches.di.MatchesFragmentModule
import com.octacoresoftwares.nearby.di.NearbyFragmentModule
import com.octacoresoftwares.profile.di.ProfileFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentModule {

    @ContributesAndroidInjector(
        modules = [
            MainModule::class,
            NearbyFragmentModule::class,
            ChatsFragmentModule::class,
            ProfileFragmentModule::class,
            MatchesFragmentModule::class
        ]
    )
    abstract fun bindsMainFragmentModule(): MainFragment
}