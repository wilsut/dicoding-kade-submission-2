package com.wilsut.footballleague

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<Item>("extra_item")

        scrollView() {
            verticalLayout {
                padding = dip(16)

                imageView =
                    imageView(item.image ?: 0).lparams(width = matchParent) {
                        margin = dip(15)
                    }

                nameTextView = textView() {
                    gravity = Gravity.CENTER
                    padding = dip(12)
                    textSize = 24f
                }

                descriptionTextView = textView()
            }
        }

        nameTextView.text = item.name
        descriptionTextView.text = item.description
    }
}

