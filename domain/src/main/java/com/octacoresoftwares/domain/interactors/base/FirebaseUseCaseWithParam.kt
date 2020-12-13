package com.octacoresoftwares.domain.interactors.base

abstract class FirebaseUseCaseWithParam <P> {

    abstract fun <C> buildFirebaseTask(params: P? = null, callback: C)

    fun <C> executeFirebaseTask(params: P? = null, callback: C) {
        buildFirebaseTask(params, callback)
    }
}