package com.android.retrofit.data

import androidx.fragment.app.Fragment

/**
 * 작성자:
 * 내용: 탭레이아웃 관리를 위한 data class
 * */
data class MainTabs(
    val fragment: Fragment, // 탭 fragment
    val title: Int, // 탭 제목
    val icon: Int, // 탭 아이콘
)