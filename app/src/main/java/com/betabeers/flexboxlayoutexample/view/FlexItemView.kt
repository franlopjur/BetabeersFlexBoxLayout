package com.betabeers.flexboxlayoutexample.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.betabeers.flexboxlayoutexample.R
import com.betabeers.flexboxlayoutexample.extension.bindView


    class FlexItemView(private val mContext: Context) : RelativeLayout(mContext) {

        private val mTextLabel = this.bindView<TextView>(R.id.widget_flex_item__label)
        private val mCloseIcon = this.bindView<ImageView>(R.id.widget_flex_item__close_icon)

        init {
            initialize()
        }

        /*
         * Private Methods
         */

        private fun initialize() {
            LayoutInflater.from(mContext).inflate(R.layout.widget_flex_item,
                    this, true)
        }

        /*
         * Public Methods
         */

        fun setClickOnCloseIconListener(function: (view: View) -> Unit) {
            mCloseIcon.value.setOnClickListener {
                function(this@FlexItemView)
            }
        }

        fun setText(text: String) {
            mTextLabel.value.text = text
        }
    }

