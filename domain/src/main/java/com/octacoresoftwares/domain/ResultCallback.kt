package com.octacoresoftwares.domain

interface ResultCallback {
    fun <R> result(r: R)
}