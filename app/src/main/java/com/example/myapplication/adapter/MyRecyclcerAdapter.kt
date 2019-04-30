package com.example.myapplication.adapter

import android.content.Context
import android.graphics.ColorSpace
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.vo.Coming
import com.example.myapplication.vo.Data
import com.example.myapplication.vo.Demo

/**
 * @Author : YFL  is Creating a porject in zhujie
 * @Package com.example.myapplication.adapter
 * @Email : yufeilong92@163.com
 * @Time :2019/4/30 14:52
 * @Purpose :
 */
class MyRecyclcerAdapter(var mContext: Context, var mData: MutableList<Coming>) :
    RecyclerView.Adapter<MyRecyclcerAdapter.ViewHolde>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyRecyclcerAdapter.ViewHolde {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item, null)
        val viewholer = ViewHolde(view)
        return viewholer

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(p0: MyRecyclcerAdapter.ViewHolde, p1: Int) {
        var img:String?=""
        if (p1%2==0){
            img="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3300305952,1328708913&fm=27&gp=0.jpg"
        }else{
            img="http://5b0988e595225.cdn.sohucs.com/images/20171111/28b25555cf644a0da42a1af2cb2b0a42.gif"
        }
        val coming = mData[p1]
        p0.tv.text = coming.videoName
        p0.title.text=coming.title
        Glide.with(mContext)
            .load(img)
            .into(p0.iv)

    }

    class ViewHolde(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv = itemView.findViewById<TextView>(R.id.tv_content)
        var iv = itemView.findViewById<ImageView>(R.id.iv_content)
        var title = itemView.findViewById<TextView>(R.id.item_tv_title)
    }
}