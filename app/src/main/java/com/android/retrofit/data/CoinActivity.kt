package com.android.retrofit.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.android.retrofit.ApiService
import com.android.retrofit.databinding.ActivityCoinBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCoinBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)
        //버튼 클릭 이벤트
        binding.searchBtn.setOnClickListener {
            //초기화
            binding.resultText.text = ""
            //api 호출
            lifecycleScope.launch { //코루틴스코프로 돌려봄 (1차)
//                apiRequest()
//            }
            }
        }
    }
}