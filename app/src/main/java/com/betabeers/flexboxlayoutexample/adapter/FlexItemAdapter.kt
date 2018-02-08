package com.betabeers.flexboxlayoutexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.betabeers.flexboxlayoutexample.view.FlexItemView

class FlexItemAdapter(private val mItems: MutableList<String>, private val mListener: CustomListener)
    : RecyclerView.Adapter<FlexItemAdapter.FlexItemViewHolder>() {

    interface CustomListener {
        fun clickOnCarItem(text: String)
        fun longClickOnCarItem(text: String)
    }

    /*
     * Private Methods
     */

    private fun getDataSet() : MutableList<String> {
        return mItems
    }

    private fun removeItem(position: Int) {
        if (getDataSet().size > position) {
            getDataSet().removeAt(position)
            notifyItemRangeRemoved(position, 1)
        } else {
            notifyDataSetChanged()
        }
    }

    /*
     * Public Methods
     */

    fun addItem(textToAdd: String) {
        getDataSet().add(textToAdd)
        notifyItemInserted(getDataSet().size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlexItemViewHolder {
        return FlexItemViewHolder(FlexItemView(parent.context))
    }

    override fun onBindViewHolder(holder: FlexItemViewHolder, position: Int) {
        val text = getDataSet()[position]
        holder.view.setText(text)

        holder.view.setClickOnCloseIconListener {
            removeItem(position)
        }

        holder.itemView.setOnLongClickListener {
            removeItem(position)
            mListener.longClickOnCarItem(text)
            true
        }

        holder.itemView.setOnClickListener {
            mListener.clickOnCarItem(text)
        }
    }

    override fun getItemCount(): Int {
        return getDataSet().size
    }

    /*
     * Inner class
     */

    class FlexItemViewHolder(var view: FlexItemView) : RecyclerView.ViewHolder(view)
}