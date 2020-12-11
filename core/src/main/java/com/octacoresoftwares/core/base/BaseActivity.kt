package com.octacoresoftwares.core.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<in D: ViewDataBinding, out V: BaseViewModel>: DaggerAppCompatActivity() {

    abstract fun getViewModel(): V?

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelBindingVariable(): Int

    abstract fun getViewDataBinding(binding: D?)

    open fun setViewModelObservers(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: D = DataBindingUtil.setContentView(this, getLayoutId())
        binding.apply {
            setVariable(getViewModelBindingVariable(), getViewModel())
            executePendingBindings()
            lifecycleOwner = this@BaseActivity
        }
        setViewModelObservers()
        getViewDataBinding(binding)
    }
}