package com.android.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.android.retrofit.data.Ticker
import com.android.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        binding.searchBtn.setOnClickListener {
            //api 호출
            lifecycleScope.launch { //코루틴스코프로 돌려봄 (1차)
                apiRequest()
            }
        }
    }

    suspend fun apiRequest() {
        //retrofit 객체 생성

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.bithumb.com/") //통신할 서버 주소명 (보통 get 주소앞까지 짤라서 사용하면 됨)
            .addConverterFactory(GsonConverterFactory.create()) //Gson,moshi 등 자신이 추가한 라이브러리를 ConverterFactory에 넣어줌
            .build()
        //서비스 객체 생성
        val apiService: ApiService = retrofit.create(ApiService::class.java)
        //Call객체 생성
        val coinName = binding.coinEdit.text.toString()
        val tickecall = apiService.getCoinTicker(coinName, "KRW")
        //네트워크통신
        tickecall.enqueue(object : Callback<Ticker> {
            override fun onResponse(call: Call<Ticker>, response: Response<Ticker>) {
                //요청이 된경우
                val data = response.body()  // 여기서 response.body() 에서 조회된 데이터들을 꺼내 뷰와 데이터를 바인딩합니다.

                binding.apply {
                    resultText.append("status :${data?.status}\n")
                    resultText.append("closing_price :${data?.data?.closing_price}\n")
                    resultText.append("opening_price :${data?.data?.opening_price}\n")
                    resultText.append("max_price :${data?.data?.max_price}\n")
                    resultText.append("min_price :${data?.data?.min_price}\n")
                }
            }

            override fun onFailure(call: Call<Ticker>, t: Throwable) {
                //요청이 안된경우
                call.cancel()
            }
        })
    }
}
