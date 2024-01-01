package com.android.retrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import coil.load
import com.android.retrofit.data.MapleData
import com.android.retrofit.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class secondFragment : Fragment() {

    companion object {
        fun newInstance(): secondFragment = secondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val TestApiKey: String =getString(R.string.nexon_api_key)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNo.setOnClickListener {
            binding.apply {
                boxSearch.isVisible = true
                blancYesOrNo.isVisible = false
            }
            binding.btnSearch.setOnClickListener {
                binding.apply {
                    boxSearch.isVisible = false
                    boxResult.isVisible = true
                }
                lifecycleScope.launch {
                    apiRequest()
                }
            }

        }
        binding.btnYes.setOnClickListener {
            binding.apply {
                binding.boxResult.isVisible = true
                binding.blancYesOrNo.isVisible = false
            }
            lifecycleScope.launch {
                blancRequest()
            }
        }
        binding.ivBackButton.setOnClickListener{
            binding.apply {
                boxResult.isVisible = false
                boxSearch.isVisible = true
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun apiRequest() {
        //1.Retrofit 객체 초기화
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //2. service 객체 생성
        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)

        //3. Call객체 생성
        val mapleNickName = binding.searchView.text.toString()
        Log.d("getNickName", "${mapleNickName}")
        val mapleCall = apiservicemaple.getocid(
            TestApiKey,
            mapleNickName,
        )
        Log.d("getmapleCall","${mapleCall}")


        //4. 네트워크 통신
        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleinfo = response.body()

                if (mapleinfo != null) {
                    var getOcid = "${mapleinfo.ocid}"
                    Log.d("getocid", "${getOcid}")

                    val charaterCall = apiservicemaple.getCharacter(
                        "test_a600e45ce67a8f1dd0d4466e7f3b0825b700dccabfd4466c92b690c34cc4d412c0f454bba65c5206af27084210f66392",
                        "${getOcid}",
                        "2023-12-30"
                    )
                    if (getOcid != null) {
                        Log.d("characterCall 시작직전", "${getOcid}")

                        charaterCall.enqueue(object : Callback<MapleData> {
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {

                                val mapleinfo2 = response.body()
                                Log.d("mapleinfo2test", "mapleinfo2: ${mapleinfo2}")

                                if (mapleinfo2 != null) {

                                    Log.d("mapleinfo2success", "mapleinfo2: ${mapleinfo2}")
                                    binding.apply {
                                        binding.ivCharacterImage.load(mapleinfo2.characterImage)
                                        tvCharacterLevel.text = "성별: ${mapleinfo2.characterGender}"
                                        tvWorldName.text = "서버: ${mapleinfo2.worldName}"
                                        tvCharacterName.text = "닉네임: ${mapleinfo2.characterName}"
                                        tvCharacterGuildName.text ="길드: ${mapleinfo2.characterGuildName}"
                                        tvCharacterExpRate.text = "경험치: ${mapleinfo2.characterExpRate}%"
                                    }


                                } else {

                                    Log.d("mapleinfo2", "mapleinfo2: ${mapleinfo2}")
                                }
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                                Log.e("Debug", "API Request Failed", t)
                                call.cancel()
                            }

                        })
                    }


                } else {

                    Log.e("Fuxxk", "mapleinfo: ${mapleinfo}")
                    Log.d("Howtypelog", "etInputUserName: ${binding.searchView}")
                    Log.d("Fuxxk", "response: ${response}")
                }

            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                Log.e("Debug", "API Request Failed", t)
                call.cancel()
            }

        })

    }

    private fun blancRequest() {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://open.api.nexon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiservicemaple: ApiServiceMaple = retrofit.create(ApiServiceMaple::class.java)


        val mapleNickName = binding.searchView.text.toString()
        val mapleCall = apiservicemaple.getocid(
            TestApiKey,
            "블랑",
        )

        mapleCall.enqueue(object : Callback<MapleData> {
            override fun onResponse(call: Call<MapleData>, response: Response<MapleData>) {

                val mapleinfo = response.body()

                if (mapleinfo != null) {
                    var getOcid = "${mapleinfo.ocid}"
                    Log.d("getocid", "${getOcid}")

                    val charaterCall = apiservicemaple.getCharacter(
                        TestApiKey,
                        "${getOcid}",
                        "2023-12-29"
                    )
                    if (getOcid != null) {
                        Log.d("characterCall 시작직전", "${getOcid}")

                        charaterCall.enqueue(object : Callback<MapleData> {
                            override fun onResponse(
                                call: Call<MapleData>,
                                response: Response<MapleData>
                            ) {

                                val mapleinfo2 = response.body()
                                Log.d("mapleinfo2test", "mapleinfo2: ${mapleinfo2}")

                                if (mapleinfo2 != null) {

                                    Log.d("mapleinfo2success", "mapleinfo2: ${mapleinfo2}")
                                    binding.ivCharacterImage.load(mapleinfo2.characterImage)
                                    binding.tvCharacterLevel.text =
                                        "Lv:${mapleinfo2.characterLevel}"
                                    binding.tvWorldName.text = "서버:${mapleinfo2.worldName}"
                                    binding.tvCharacterName.text = "닉네임:${mapleinfo2.characterName}"
                                    binding.tvCharacterGuildName.text =
                                        "길드:${mapleinfo2.characterGuildName}"
                                    binding.tvCharacterExpRate.text =
                                        "경험치:${mapleinfo2.characterExpRate}%"


                                } else {

                                    Log.d("mapleinfo2", "mapleinfo2: ${mapleinfo2}")
                                }
                            }

                            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                                Log.e("Debug", "API Request Failed", t)
                                call.cancel()
                            }

                        })
                    }


                } else {

                    Log.e("Fuxxk", "mapleinfo: ${mapleinfo}")
                    Log.d("Howtypelog", "etInputUserName: ${binding.searchView}")
                    Log.d("Fuxxk", "response: ${response}")
                }

            }

            override fun onFailure(call: Call<MapleData>, t: Throwable) {

                Log.e("Debug", "API Request Failed", t)
                call.cancel()
            }

        })

    }

}