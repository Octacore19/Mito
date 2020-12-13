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
import androidx.annotation.NavigationRes
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.octacoresoftwares.core.utils.AppLog
import dagger.android.support.DaggerFragment

abstract class BaseFragment<in D : ViewDataBinding, out V : BaseViewModel> : DaggerFragment() {

    abstract fun getViewModel(): V?

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelBindingVariable(): Int

    abstract fun setViewDataBinding(binding: D?)

    open fun setViewModelObservers() {}

    fun setBackPressedListener(fragment: Fragment, action: () -> Unit) {
        requireActivity().onBackPressedDispatcher.addCallback(fragment, true) {
            AppLog.d("Back button triggered")
            action.invoke()
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

    fun setFragmentNavController() {
        fragmentNavController = findNavController()
    }

    fun setFragmentNavController(@IdRes containerId: Int) {
        val host = childFragmentManager.findFragmentById(containerId) as NavHostFragment
        fragmentNavController = host.navController
    }

    fun setNavigationGraph(@IdRes containerId: Int, @NavigationRes graphId: Int) {
        val host = NavHostFragment.create(graphId)
        childFragmentManager.beginTransaction()
            .replace(containerId, host)
            .commit()
    }
}