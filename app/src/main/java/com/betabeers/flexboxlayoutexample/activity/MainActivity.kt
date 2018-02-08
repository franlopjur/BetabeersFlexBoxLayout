package com.betabeers.flexboxlayoutexample.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betabeers.flexboxlayoutexample.R
import com.betabeers.flexboxlayoutexample.extension.bindView

class MainActivity : AppCompatActivity() {

    private var mNormalFblBtn: Lazy<Button> = bindView(R.id.main__normal_fbl_btn)
    private var mRecyclerFblBtn: Lazy<Button> = bindView(R.id.main__recycler_fbl_btn)

    /*
     * Private Methods
     */

    private fun setUpBtn() {
        mNormalFblBtn.value.setOnClickListener {
            goToNormalFlexBoxLayoutActivity()
        }

        mRecyclerFblBtn.value.setOnClickListener {
            goToRecyclerFlexBoxLayoutActivity()
        }
    }

    private fun goToNormalFlexBoxLayoutActivity() {
        startActivity(Intent(this@MainActivity,
                NormalFlexBoxLayoutActivity::class.java))
    }

    private fun goToRecyclerFlexBoxLayoutActivity() {
        startActivity(Intent(this@MainActivity,
                RecyclerFlexBoxLayoutActivity::class.java))
    }

    /*
     * Public Methods
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBtn()
    }
}
