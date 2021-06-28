package com.example.simplemvvmexample.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.simplemvvmexample.R
import com.example.simplemvvmexample.databinding.FragmentOneBinding
import com.example.simplemvvmexample.viewmodel.FragmentInteractionVM

class FragmentOne : Fragment() {

    private lateinit var viewDataBinding : FragmentOneBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(FragmentInteractionVM::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentOneBinding.inflate(inflater , container , false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.executePendingBindings()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}