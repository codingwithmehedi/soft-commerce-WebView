package soft.com.softcommerce.ui


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import soft.com.softcommerce.R
import soft.com.softcommerce.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN)

        binding.spImageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@SplashActivity, WebActivity::class.java))
            finishAffinity()
        }, 2500)
    }
}