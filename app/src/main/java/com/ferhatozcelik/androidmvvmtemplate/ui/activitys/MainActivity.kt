package com.ferhatozcelik.androidmvvmtemplate.ui.activitys

import android.os.Bundle
import android.util.Log
import com.ferhatozcelik.androidmvvmtemplate.databinding.ActivityMainBinding
import com.ferhatozcelik.androidmvvmtemplate.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate()")
    }

}
