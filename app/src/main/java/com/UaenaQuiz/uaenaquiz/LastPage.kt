package com.UaenaQuiz.uaenaquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UaenaQuiz.App
import com.UaenaQuiz.uaenaquiz.BaseActivity.Companion.firstBoolean
import com.UaenaQuiz.uaenaquiz.BaseActivity.Companion.secondBoolean
import com.UaenaQuiz.uaenaquiz.databinding.ActivityLastPageBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class LastPage : BaseActivity() {

    lateinit var mAdView : AdView
    private var mBinding: ActivityLastPageBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLastPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = adUnitId

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        binding.answerCount.text = "${App.prefs.getCount("")} / 30"


        if(App.prefs.getCount("").toInt()  <= 5) {
            binding.lastMent.text = "유애나인지 의심이 되네요..."
        }
        if (App.prefs.getCount("").toInt() == 30) {
            binding.lastMent.text = "혹시 아이유 본인?"
        }
        if (App.prefs.getCount("").toInt() in 25..29) {
            binding.lastMent.text = "진정한 유애나이시네요!"
        }
        if(App.prefs.getCount("").toInt() in 6..15) {
            binding.lastMent.text = "다시 복습하고 오세요!"
        }
        if(App.prefs.getCount("").toInt() in 16..24) {
            binding.lastMent.text = "다음에는 만점 도전해봐요~"
        }

        App.prefs.getCount("0")
        App.prefs.getBoolean(firstBoolean, true)
        App.prefs.getBoolean(secondBoolean, true)
        App.prefs.getBoolean(thirdBoolean, true)
        App.prefs.getBoolean(fourthBoolean, true)
        App.prefs.getBoolean(fifthBoolean, true)
        App.prefs.getBoolean(sixthBoolean, true)
        App.prefs.getBoolean(seventhBoolean, true)
        App.prefs.getBoolean(eighthBoolean, true)
        App.prefs.getBoolean(ninthBoolean, true)
        App.prefs.getBoolean(tenthBoolean, true)
        App.prefs.getBoolean(eleventhBoolean, true)
        App.prefs.getBoolean(twelfthBoolean, true)
        App.prefs.getBoolean(thirteenthBoolean, true)
        App.prefs.getBoolean(fourteenthBoolean, true)
        App.prefs.getBoolean(fifteenthBoolean, true)
        App.prefs.getBoolean(sixteenthBoolean, true)
        App.prefs.getBoolean(seventeenthBoolean, true)
        App.prefs.getBoolean(eighteenthBoolean, true)
        App.prefs.getBoolean(ninteenthBoolean, true)
        App.prefs.getBoolean(twentiethBoolean, true)
        App.prefs.getBoolean(twentyfirstBoolean, true)
        App.prefs.getBoolean(twentysecondBoolean, true)
        App.prefs.getBoolean(twentythirdBoolean, true)
        App.prefs.getBoolean(twentyfourthBoolean, true)
        App.prefs.getBoolean(twentyfifthBoolean, true)
        App.prefs.getBoolean(twentysixthBoolean, true)
        App.prefs.getBoolean(twentysevenBoolean, true)
        App.prefs.getBoolean(twentyeighthBoolean, true)
        App.prefs.getBoolean(twentyNinthBoolean, true)
        App.prefs.getBoolean(thirtiethBoolean, true)
        App.prefs.getBoolean(thirtyfirstBoolean, true)
        App.prefs.getBoolean(thirtySecondBoolean, true)
        App.prefs.getBoolean(thirtyThirdBoolean, true)
        App.prefs.getBoolean(thirtyFourthBoolean, true)


        binding.button.setOnClickListener {
            App.prefs.setCount("0")
            App.prefs.setBoolean(firstBoolean, true)
            App.prefs.setBoolean(secondBoolean, true)
            App.prefs.setBoolean(thirdBoolean, true)
            App.prefs.setBoolean(fourthBoolean, true)
            App.prefs.setBoolean(fifthBoolean, true)
            App.prefs.setBoolean(sixthBoolean, true)
            App.prefs.setBoolean(seventhBoolean, true)
            App.prefs.setBoolean(eighthBoolean, true)
            App.prefs.setBoolean(ninthBoolean, true)
            App.prefs.setBoolean(tenthBoolean, true)
            App.prefs.setBoolean(eleventhBoolean, true)
            App.prefs.setBoolean(twelfthBoolean, true)
            App.prefs.setBoolean(thirteenthBoolean, true)
            App.prefs.setBoolean(fourteenthBoolean, true)
            App.prefs.setBoolean(fifteenthBoolean, true)
            App.prefs.setBoolean(sixteenthBoolean, true)
            App.prefs.setBoolean(seventeenthBoolean, true)
            App.prefs.setBoolean(eighteenthBoolean, true)
            App.prefs.setBoolean(ninteenthBoolean, true)
            App.prefs.setBoolean(twentiethBoolean, true)
            App.prefs.setBoolean(twentyfirstBoolean, true)
            App.prefs.setBoolean(twentysecondBoolean, true)
            App.prefs.setBoolean(twentythirdBoolean, true)
            App.prefs.setBoolean(twentyfourthBoolean, true)
            App.prefs.setBoolean(twentyfifthBoolean, true)
            App.prefs.setBoolean(twentysixthBoolean, true)
            App.prefs.setBoolean(twentysevenBoolean, true)
            App.prefs.setBoolean(twentyeighthBoolean, true)
            App.prefs.setBoolean(twentyNinthBoolean, true)
            App.prefs.setBoolean(thirtiethBoolean, true)
            App.prefs.setBoolean(thirtyfirstBoolean, true)
            App.prefs.setBoolean(thirtySecondBoolean, true)
            App.prefs.setBoolean(thirtyThirdBoolean, true)
            App.prefs.setBoolean(thirtyFourthBoolean, true)


            val intent = Intent(this, ProblemList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }

    }
}