package com.octacoresoftwares.core.navs

import androidx.fragment.app.Fragment
import com.octacoresoftwares.core.navigation.IMainNavigation
import com.octacoresoftwares.domain.navigation.IMainNav
import javax.inject.Inject

class MainNav @Inject constructor(private val nav: IMainNavigation): IMainNav {
    override fun <T> actionMainBackTo(t: T) {
        nav.actionBackMain(t as Fragment)
    }
}