package com.UaenaQuiz.uaenaquiz

import android.content.Intent
import android.os.Bundle
import com.UaenaQuiz.uaenaquiz.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class MainActivity : BaseActivity() {

    lateinit var mAdView : AdView

    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 자동 생성된 뷰 바인딩 클래스에서의 "inflate"라는 메서드를 활용해서 // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = adUnitId

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        binding.startBtn.setOnClickListener {
            val intent = Intent(this, ProblemList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }
    }
}