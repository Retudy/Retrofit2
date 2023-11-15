package com.android.retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.retrofit.databinding.FragmentFirstBinding



class firstFragment : Fragment() {
    companion object {

        fun newInstance() : firstFragment = firstFragment()
    }
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //이건 데이터 클래스
        val items = mutableListOf<firstModel>()
        items.add(firstModel("윤동현","01049834992"))
        items.add(firstModel("스파르타","01043314992"))



        val rv = binding.rvFirstFragment
        val rvAdapter = firstAdapter(items)

        rv.adapter = rvAdapter // 리싸이클러뷰에서 어댑터 = 내가만든 어댑터 다 해서 연결해준다.
        rv.layoutManager = LinearLayoutManager(context) // 리싸이클러뷰의 레이아웃매니저 = 리니어레이아웃매니저(컨텍스트를담아서)  다 해서 연결해준다. //이부분 정확히 모르겠음

        rvAdapter.itemClick = object : firstAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(context,"${items[position]}",Toast.LENGTH_SHORT).show()
                Log.d("Click","${items[position]}")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}