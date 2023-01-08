package com.choius323.afreecatest.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choius323.afreecatest.KEY_BROAD
import com.choius323.afreecatest.databinding.ActivityBroadDetailBinding
import com.choius323.domain.model.Broad

class BroadDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBroadDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBroadDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        val broad = intent.getSerializableExtra(KEY_BROAD) as? Broad
        binding.broad = broad
    }

    companion object {
        fun newInstance(context: Context, broad: Broad) {
            val intent = Intent(context, BroadDetailActivity::class.java)
            intent.putExtra(KEY_BROAD, broad)
            context.startActivity(intent)
        }
    }
}