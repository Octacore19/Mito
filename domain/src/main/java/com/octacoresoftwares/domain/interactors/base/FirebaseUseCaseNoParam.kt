package com.octacoresoftwares.domain.interactors.base

abstract class FirebaseUseCaseNoParam {

    abstract fun <C> buildFirebaseTask(callback: C)

    fun <C> executeFirebaseTask(callback: C) {
        buildFirebaseTask(callback)
    }
}