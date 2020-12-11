package com.octacoresoftwares.domain.interactors

abstract class FirebaseUseCaseNoParam <P> {

    abstract fun <C> buildFirebaseTask(params: P? = null, callback: C)

    fun <C> executeFirebaseTask(params: P? = null, callback: C) {
        buildFirebaseTask(params, callback)
    }
}