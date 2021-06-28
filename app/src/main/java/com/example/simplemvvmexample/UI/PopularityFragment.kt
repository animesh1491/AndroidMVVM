package com.example.simplemvvmexample.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.simplemvvmexample.R
import com.example.simplemvvmexample.databinding.FragmentPopularityBinding
import com.example.simplemvvmexample.databinding.FragmentTwoBinding
import com.example.simplemvvmexample.viewmodel.FragmentInteractionVM

class PopularityFragment : Fragment() {

    private lateinit var viewDataBinding : FragmentPopularityBinding

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(FragmentInteractionVM::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentPopularityBinding.inflate(inflater , container , false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewModel = viewModel
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.executePendingBindings()
    }

    companion object {
        @JvmStatic
        fun newInstance() = PopularityFragment()
    }
}