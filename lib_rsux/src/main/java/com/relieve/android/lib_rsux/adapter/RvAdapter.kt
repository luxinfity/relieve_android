package com.relieve.android.lib_rsux.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.relieve.android.lib_rsux.base.Component
import com.relieve.android.lib_rsux.base.RelieveViewHolder

abstract class RvAdapter<C: Component<C, VH>, VH: RelieveViewHolder<C, VH>>(val ctx: Context)
    : RecyclerView.Adapter<VH>() {

    protected val components = ArrayList<C>()

    override fun getItemCount(): Int = components.size

    override fun getItemViewType(position: Int): Int =
        components[position].viewType

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(components[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        components.find { it.viewType == viewType }!!.createViewHolder(parent)


    fun add (component: C) {
        val currentSize = components.size
        components.add(component)
        notifyItemInserted(currentSize)
    }

    fun remove (component: C) {
        val index = components.indexOf(component)
        if (index > -1) {
            components.remove(component)
            notifyItemRemoved(index)
        }
    }

    fun remove (index: Int) {
        if (index > -1 && index < components.size) {
            components.removeAt(index)
            notifyItemRemoved(index)
        }
    }
}