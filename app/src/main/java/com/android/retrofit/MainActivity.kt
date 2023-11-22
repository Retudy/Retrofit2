package com.android.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.android.retrofit.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewPagerAdapter by lazy { ViewPager2Adapter(this) } // 1. 뷰페이저2 어뎁터 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        viewPager2State()
        setupTabIcons()

        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager2
        ) { tab, position ->
            tab.setText(viewPagerAdapter.getTitme(position))
            tab.setIcon(viewPagerAdapter.getIcon(position))
        }.attach()

        pageChangeCallBack()
        binding.viewPager2.offscreenPageLimit = viewPagerAdapter.itemCount

    }

    private fun viewPager2State() {
        binding.viewPager2.apply {
            adapter = viewPagerAdapter
            setCurrentItem(
                viewPagerAdapter.findFragmentTabIndex(R.string.member_second),
                false
            )
            setUserInputEnabled(false) //  이거 뭔지 아시는분
        }
    }

    private fun pageChangeCallBack() {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            var currentState = 0
            var currentPosition = 0

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (currentState == ViewPager2.SCROLL_STATE_DRAGGING && currentPosition == position) {
                    if (currentPosition == 0) binding.viewPager2.currentItem = 4
                    else if (currentPosition == 4) binding.viewPager2.currentItem = 0
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                currentPosition = position
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                currentState = state
                super.onPageScrollStateChanged(state)
            }
        })
    }

    /**
     * 작성자:
     * 내용: 홈 탭에서 다른 탭으로 이동시 사용
     * ViewPagerAdapter에서 Tab 이름을 검색하여 나온
     * index값을 가져와 Tab 현재위치를 바꿔줌
     * */
    fun moveTabFragment(title: Int) {
        val index = viewPagerAdapter.findFragmentTabIndex(title)
        binding.viewPager2.setCurrentItem(index, false)
    }

    private fun setupTabIcons() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val icon = when (tab?.position) {
                    0 -> R.drawable.budget
                    1 -> R.drawable.community
                    2 -> R.drawable.home
                    3 -> R.drawable.scrap
                    4 -> R.drawable.mypage
                    else -> R.drawable.pic_yoon
                }
                tab?.setIcon(icon)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //반전이미지 만드는법 -> 성환님한테 피그마 물어보기
                val icon = when (tab?.position) {
                    0 -> R.drawable.budget
                    1 -> R.drawable.community
                    2 -> R.drawable.home
                    3 -> R.drawable.scrap
                    4 -> R.drawable.mypage
                    else -> R.drawable.pic_yoon
                }
                tab?.setIcon(icon)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
}
