package com.getbehavior.getbehavior

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_race.view.*
import kotlinx.android.synthetic.main.item_title.view.*

import java.util.ArrayList

class HupuAdapter : RecyclerView.Adapter<HupuAdapter.HuPuViewHolder>() {

    internal var data: MutableList<Race> = ArrayList()

    fun setData(data: List<Race>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuPuViewHolder {
        val layoutResId = R.layout.item_race
        return HuPuViewHolder(LayoutInflater.from(parent.context).inflate(layoutResId, parent, false))
    }

    override fun onBindViewHolder(holder: HuPuViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class HuPuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            val item = data[adapterPosition]


            itemView.teams.text = "${item.blueTeam}   vs   ${item.redTeam}"
            itemView.score.text = "${item.score}"


        }
    }

}
