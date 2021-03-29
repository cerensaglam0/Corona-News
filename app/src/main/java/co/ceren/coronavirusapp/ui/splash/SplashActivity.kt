package co.ceren.coronavirusapp.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.BounceInterpolator
import androidx.appcompat.app.AppCompatActivity
import co.ceren.coronavirusapp.databinding.ActivitySplashBinding
import co.ceren.coronavirusapp.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startImageViewAnimation()
        startTextViewAnimation()
        openMainActivity()
    }

    private fun startImageViewAnimation() {
        binding.imageViewSplashCoronaVirus.post {
            ObjectAnimator.ofFloat(binding.imageViewSplashCoronaVirus, "rotation", 0F, 360F).apply {
                duration = 800
                start()
            }
        }
    }

    private fun startTextViewAnimation() {
        binding.textViewSplashCoronApp.post {
            ObjectAnimator.ofFloat(binding.textViewSplashCoronApp, "alpha", 0F, 1F).apply {
                duration = 1000
                startDelay = 750
                start()
            }
        }
    }

    private fun openMainActivity() {
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2200)
    }
}