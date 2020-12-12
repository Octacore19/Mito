package com.octacoresoftwares.core.base

import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.addCallback
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment<in D : ViewDataBinding, out V : BaseViewModel>: DaggerFragment() {

    abstract fun getViewModel(): V?

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelBindingVariable(): Int

    abstract fun setViewDataBinding(binding: D?)

    open fun setViewModelObservers(){}

    open fun setBackPressedListener(){
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, true) {
            fragmentNavController?.navigateUp()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: D = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply {
            setVariable(getViewModelBindingVariable(), getViewModel())
            lifecycleOwner = this@BaseFragment
            executePendingBindings()
        }
        setViewModelObservers()
        setViewDataBinding(binding)
        setBackPressedListener()
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

    private var fragmentNavController: NavController? = null

    fun getFragmentNavController() = fragmentNavController

    fun setFragmentNavController(@IdRes id: Int) {
        fragmentNavController = requireActivity().findNavController(id)
    }

    fun setFragmentNavController() {
        fragmentNavController = findNavController()
    }
}