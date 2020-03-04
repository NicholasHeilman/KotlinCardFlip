package com.cardflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var showingBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null ) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, CardFrontFragment())
                .commit()
        }
        flip_btn.setOnClickListener {
            flipCard()
        }
    }
    private fun flipCard() {
        if (showingBack) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.animator.card_flip_right_in,
                    R.animator.card_flip_right_out,
                    R.animator.card_flip_left_in,
                    R.animator.card_flip_left_out
                )
                .replace(R.id.container, CardFrontFragment())
                .addToBackStack(null)
                .commit()
            showingBack = false
            flip_btn.text = "Show Back"
        } else {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.animator.card_flip_right_in,
                    R.animator.card_flip_right_out,
                    R.animator.card_flip_left_in,
                    R.animator.card_flip_left_out
                )
                .replace(R.id.container, CardBackFragment())
                .addToBackStack(null)
                .commit()
            showingBack = true
            flip_btn.text = "Show Front"
        }
    }
}

