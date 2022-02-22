package com.example.uaenaquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uaenaquiz.databinding.ActivityLastPageBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class LastPage : AppCompatActivity() {

    lateinit var mAdView : AdView

    private var mBinding: ActivityLastPageBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_page)

        mBinding = ActivityLastPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        var answerCount = Integer.parseInt(intent.getIntExtra("answer",0).toString())
        binding.answerCount.text = "정답 수: " + answerCount.toString() + "/8"

        binding.button.setOnClickListener {
            var intent = Intent(this, ProblemList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }

    }
}