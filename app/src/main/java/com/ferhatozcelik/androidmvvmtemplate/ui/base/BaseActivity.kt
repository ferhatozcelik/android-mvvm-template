package com.ferhatozcelik.androidmvvmtemplate.ui.base

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.ferhatozcelik.androidmvvmtemplate.R

abstract class BaseActivity<VB : ViewBinding>(private val bindingFactory: (LayoutInflater) -> VB) : AppCompatActivity() {
    private val TAG = BaseActivity::class.java.simpleName

    lateinit var binding: VB
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate()")
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        initStartFragment()
    }

    private fun initStartFragment() {
        Log.i(TAG, "initStartFragment()")
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        val navController = navHostFragment.navController
        navController.setGraph(graph, intent.extras)
    }

}