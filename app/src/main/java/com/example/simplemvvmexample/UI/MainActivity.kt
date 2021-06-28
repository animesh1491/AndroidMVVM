package com.example.simplemvvmexample.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.simplemvvmexample.R
import com.example.simplemvvmexample.databinding.ActivityMainBinding
import com.example.simplemvvmexample.viewmodel.FragmentInteractionVM

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding : ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this).get(FragmentInteractionVM::class.java)
    }

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.viewModel = viewModel
        activityMainBinding.executePendingBindings()
        setListener()
        addFragmentOne()
        addFragmentTwo()
    }

    private fun addFragmentOne() {
        supportFragmentManager.beginTransaction().add(R.id.container_one, FragmentOne.newInstance(), "FragmentOne").commit()
    }

    private fun addFragmentTwo() {
        supportFragmentManager.beginTransaction().add(R.id.container_two, FragmentTwo.newInstance(), "FragmentTwo").commit()
    }

    private fun setListener() {
        activityMainBinding.tvPopularity.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.container_three, PopularityFragment.newInstance(), "PopularityFragment").addToBackStack(null).commit()
        }
    }


}