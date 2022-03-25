package com.example.favdishes.presentation.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.favdishes.R
import com.example.favdishes.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        hideNotificationBar()
        loadAnimation()
    }

    private fun isVersionHigherThanR() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R

    private fun hideNotificationBar() {
        if (isVersionHigherThanR()) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun loadAnimation() {
        val splashAnim = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        binding.tvAppName.animation = splashAnim
        splashAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(MainActivity.newActivity(this@SplashActivity))
                    finish()
                }, HANDLER_DELAY)
            }

            override fun onAnimationRepeat(p0: Animation?) {}

        })
    }

    companion object {
        private const val HANDLER_DELAY = 1000L
    }


}