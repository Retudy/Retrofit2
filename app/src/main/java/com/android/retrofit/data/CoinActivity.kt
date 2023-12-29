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
                apiRequest()
            }
        }
    }

    /**
     * HTTP api 호출
     * 작성자: 윤동현
     */
    private fun apiRequest() {
        //1.Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.bithumb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiService: ApiService = retrofit.create(ApiService::class.java)

        //3. Call객체 생성
        val coinNm = binding.coinEdit.text.toString().uppercase()// 입력값, 대문자로
        val tickerCall = apiService.getCoinTicker(coinNm, "KRW")

        //4. 네트워크 통신
        tickerCall.enqueue(object : Callback<Ticker> {
            override fun onResponse(call: Call<Ticker>, response: Response<Ticker>) {
                //호출데이터
                val tickerinfo = response.body()

                binding.resultText.append("status :${tickerinfo?.status}\n")
                binding.resultText.append("closing_price :${tickerinfo?.data?.closing_price}\n")
                binding.resultText.append("opening_price :${tickerinfo?.data?.opening_price}\n")
                binding.resultText.append("max_price :${tickerinfo?.data?.max_price}\n")
                binding.resultText.append("min_price :${tickerinfo?.data?.min_price}\n")
            }

            override fun onFailure(call: Call<Ticker>, t: Throwable) {
                //오류 시 발생
                call.cancel()
            }

        })

    }
}