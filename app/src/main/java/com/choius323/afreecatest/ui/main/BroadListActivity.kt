package com.choius323.afreecatest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choius323.afreecatest.databinding.ActivityBroadListBinding

class BroadListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBroadListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}