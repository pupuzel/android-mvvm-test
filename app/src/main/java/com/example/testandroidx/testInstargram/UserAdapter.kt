package com.example.testandroidx.testInstargram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidx.R
import kotlinx.android.synthetic.main.instargram_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder> {

    val context :Context
    val list :ArrayList<UserVo>
    val model :InstargramViewModel

    constructor(context : Context, list :ArrayList<UserVo> , model: InstargramViewModel){
        this.context = context
        this.list = list
        this.model = model
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var itemview = inflater.inflate(R.layout.instargram_item, parent , false)

        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userVo = list.get(position)
        holder.itemView.user_id.text = userVo.id
        holder.itemView.user_id.text = userVo.id
        holder.itemView.btn.setOnClickListener {
            if(holder.itemView.btn.text.equals("팔로잉")){
                holder.itemView.btn.background = ContextCompat.getDrawable(context, R.drawable.bg_blue)
                holder.itemView.btn.text = "팔로우"
                model.decrease()
            }else{
                holder.itemView.btn.background = ContextCompat.getDrawable(context, R.drawable.bg_gray)
                holder.itemView.btn.text = "팔로잉"
                model.increase()
            }
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(itemview :View) : RecyclerView.ViewHolder(itemview)
}