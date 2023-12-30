package com.android.retrofit.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.android.retrofit.data.Data
import com.android.retrofit.databinding.FragmentFirstItemBinding

class FirstAdapter2(val items: MutableList<Data> ):RecyclerView.Adapter<FirstAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstAdapter2.ViewHolder {

       val binding = FragmentFirstItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    interface ItemClick {

        fun onClick(view: View, position: Int)
    }

    var itemClick2: ItemClick? = null
    override fun onBindViewHolder(holder: FirstAdapter2.ViewHolder, position: Int) {
       if (itemClick2 != null){
           holder.itemView.setOnClickListener { v ->
               itemClick2?.onClick(v, position)
           }
       }
        holder.binditems2(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class ViewHolder(private val binding: FragmentFirstItemBinding):RecyclerView.ViewHolder(binding.root){

        fun binditems2 (items:Data ){
            binding.textView2.text = items.closing_price
            binding.rvnum.text = items.opening_price
            binding.rvDivNm.text = items.max_price
//            binding.rvPicture.load(item.picture)

        }
    }
}