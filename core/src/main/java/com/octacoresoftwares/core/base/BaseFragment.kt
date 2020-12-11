package com.octacoresoftwares.core.base

import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerFragment

abstract class BaseFragment<in D : ViewDataBinding, out V : BaseViewModel>: DaggerFragment() {

    abstract fun getViewModel(): V?

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelBindingVariable(): Int

    abstract fun getViewDataBinding(binding: D?)

    open fun setViewModelObservers(){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: D = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            setVariable(getViewModelBindingVariable(), getViewModel())
            executePendingBindings()
            lifecycleOwner = this@BaseFragment
        }
        setViewModelObservers()
        getViewDataBinding(binding)
        return binding.root
    }

    fun hideKeyBoard(token: IBinder) {
        val inputMethodManager = requireActivity().getSystemService<InputMethodManager>()
        inputMethodManager?.hideSoftInputFromWindow(token, 0)
    }

    fun showKeyBoard() {
        val inputMethodManager = requireActivity().getSystemService<InputMethodManager>()
        inputMethodManager?.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }
}