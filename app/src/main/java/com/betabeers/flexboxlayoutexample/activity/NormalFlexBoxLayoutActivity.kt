package com.betabeers.flexboxlayoutexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.betabeers.flexboxlayoutexample.R
import com.betabeers.flexboxlayoutexample.extension.bindView
import com.betabeers.flexboxlayoutexample.extension.clear
import com.betabeers.flexboxlayoutexample.view.FlexItemView
import com.google.android.flexbox.FlexboxLayout

import kotlinx.android.synthetic.main.activity_normal_flexbox_layout.*

class NormalFlexBoxLayoutActivity : AppCompatActivity() {


    private var mLayoutContainer: Lazy<FlexboxLayout> =
            bindView(R.id.normal_flex_box_layout__container)


    private var mTextInput: Lazy<EditText> = bindView(R.id.recycler_flex_box_layout__input)
    private var mAcceptBtn: Lazy<Button> = bindView(R.id.recycler_flex_box_layout__accept_btn)


    /*
     * Private Methods
     */

    private fun setUpAcceptBtn() {
        mAcceptBtn.value.setOnClickListener {
            val itemToAdd = createFlexItem(mTextInput.value.text.toString())
            mTextInput.value.clear()
            mLayoutContainer.value.addView(itemToAdd)
        }
    }

    private fun createFlexItem(text: String) : FlexItemView {
        val itemToAdd = FlexItemView(this@NormalFlexBoxLayoutActivity)
        itemToAdd.setClickOnCloseIconListener {
            mLayoutContainer.value.removeView(it)
        }
        itemToAdd.setText(text)
        return itemToAdd
    }

    /*
     * Public Methods
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_flexbox_layout)
        setSupportActionBar(toolbar)

        setUpAcceptBtn()
    }
}
