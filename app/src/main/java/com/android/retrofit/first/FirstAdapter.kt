package com.android.retrofit.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.retrofit.data.MapleData
import com.android.retrofit.databinding.FragmentFirstItemBinding

//class firstAdapter(val items: MutableList<MapleData>) :{}


//    RecyclerView.Adapter<firstAdapter.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        //4번
//        val binding =
//            FragmentFirstItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        // 뷰홀더 안에 view를넣어서 리턴해준다
//        return ViewHolder(binding)
//    }
//
//    interface ItemClick {
//        fun onClick(view: View, position: Int)
//    }
//
//    var itemClick: ItemClick? = null
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        if (itemClick != null) {
//            holder.itemView.setOnClickListener { v ->
//                itemClick?.onClick(v, position)
//            }
//        }
//        //3번. 리싸이클러뷰를 바인딩해주고
//        holder.bindItems(items[position])
//    }
//
//    override fun getItemCount(): Int {
//        // 전체의 갯수를 알려주는 친구다 1번
//        return items.size
//    }
//
//    inner class ViewHolder(private val binding: FragmentFirstItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        //2번
//        fun bindItems(item: DustItem) {
//            binding.textView2.text = item.sidoName
//            binding.rvnum.text = item.pm10Value
//            binding.rvDivNm.text = item.pm25Grade
////            binding.rvPicture.load(item.picture)
//
//
//
//        }
//    }
