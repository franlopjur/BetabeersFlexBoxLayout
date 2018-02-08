package com.betabeers.flexboxlayoutexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.betabeers.flexboxlayoutexample.adapter.FlexItemAdapter
import com.betabeers.flexboxlayoutexample.R
import com.betabeers.flexboxlayoutexample.extension.bindView
import com.betabeers.flexboxlayoutexample.extension.showToast
import com.google.android.flexbox.*

import kotlinx.android.synthetic.main.activity_recycler_flex_box_layout.*

class RecyclerFlexBoxLayoutActivity : AppCompatActivity(), FlexItemAdapter.CustomListener {

    private var mViewList = bindView<RecyclerView>(R.id.recycler_flex_box_layout__list)
    private var mTextInput = bindView<EditText>(R.id.recycler_flex_box_layout__input)
    private var mAcceptBtn = bindView<Button>(R.id.recycler_flex_box_layout__accept_btn)

    private var mItemList = mutableListOf<String>()

    private var mAdapter: FlexItemAdapter = FlexItemAdapter(mItemList, this)

    /*
     * Private Methods
     */

    private fun setUpRecyclerView() {
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.justifyContent = JustifyContent.FLEX_START
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.flexWrap = FlexWrap.WRAP
        mViewList.value.layoutManager = layoutManager
        mViewList.value.adapter = mAdapter
    }

    private fun setUpAcceptBtn() {
        mAcceptBtn.value.setOnClickListener {
            mAdapter.addItem(mTextInput.value.text.toString())
            mTextInput.value.setText("")
        }
    }

    /*
     * Public Methods
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_flex_box_layout)
        setSupportActionBar(toolbar)

        setUpAcceptBtn()
        setUpRecyclerView()
    }

    /*
     * Interface FlexItemAdapter.CustomListener
     */

    override fun clickOnCarItem(text: String) {
        showToast(String.format("Click en %s", text))
    }

    override fun longClickOnCarItem(text: String) {
        showToast(String.format("Long click en %s", text))
    }
}
