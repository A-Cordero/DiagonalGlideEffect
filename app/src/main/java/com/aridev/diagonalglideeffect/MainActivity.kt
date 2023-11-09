package com.aridev.diagonalglideeffect

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.aridev.diagonalglideeffect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            action()
        }
    }

    private fun action() {
        animationView(Color.LTGRAY, 800)
        animationView(Color.GRAY, 400)
        animationView(Color.BLACK, 0)
    }

    private fun animationView(color : Int, durationHandler : Long) {

        val view1 = TriangleView(this, color)
        val view2 = TriangleView(this, color)
        view2.rotation = 180f
        binding.root.addView(view1)
        binding.root.addView(view2)


        Handler(Looper.getMainLooper()).postDelayed({

            val screenWidth = resources.displayMetrics.widthPixels.toFloat()
            val screenHeight = resources.displayMetrics.heightPixels.toFloat()

            val translator1XAnimator =
                ObjectAnimator.ofFloat(view1, View.TRANSLATION_X, 0f, -screenWidth)

            val translator1YAnimator =
                ObjectAnimator.ofFloat(view1, View.TRANSLATION_Y, 0f, screenHeight)

            val translator2XAnimator =
                ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0f, screenWidth)

            val translator2YAnimator =
                ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0f, -screenHeight)


            val animatorSet = AnimatorSet()

            animatorSet.playTogether(
                translator1XAnimator,
                translator1YAnimator,
                translator2XAnimator,
                translator2YAnimator
            )

            animatorSet.duration = 2500
            animatorSet.start()

        }, durationHandler)

    }

}