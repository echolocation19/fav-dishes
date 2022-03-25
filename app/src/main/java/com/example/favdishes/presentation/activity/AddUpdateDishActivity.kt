package com.example.favdishes.presentation.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.favdishes.R
import com.example.favdishes.databinding.ActivityAddUpdateDishesBinding
import com.example.favdishes.databinding.DialogSelectCustomImageBinding

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAddUpdateDishesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUpdateDishesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBar()
        binding.ivAddDishImage.setOnClickListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbarAddDishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarAddDishActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupSelectCustomImageDialog() {
        val dialog = Dialog(this)
        val binding: DialogSelectCustomImageBinding =
            DialogSelectCustomImageBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        binding.tvCamera.setOnClickListener {
            Toast.makeText(this, "Okay", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        binding.tvGallery.setOnClickListener {
            Toast.makeText(this, "Okay", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        dialog.show()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_add_dish_image -> {
                Toast.makeText(this, "Okay", Toast.LENGTH_SHORT)
                    .show()
                setupSelectCustomImageDialog()
            }
        }
    }
}