package com.UaenaQuiz.uaenaquiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.UaenaQuiz.App
import com.UaenaQuiz.uaenaquiz.databinding.ActivitySeventhBinding

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

/////////
open class seventh : BaseActivity() {
    lateinit var mAdView : AdView
    private var mBinding: ActivitySeventhBinding? = null
    private val binding get() = mBinding!!
    //애니메이션 객체
    lateinit var fadeInAnim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val checkBoolean : String = seventhBoolean

        val answer_text:String = "정답\n" +
                "김윤석 배우가 출연해 서로의 손목을 묶는 씬을 촬영하였다."
        val wrong_answer_text:String = "오답\n" +
                "김윤석 배우가 출연해 서로의 손목을 묶는 씬을 촬영하였다."

        //fade in 애니메이션 객체 생성
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.change_activity)

        mBinding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = adUnitId
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //메인화면창으로 이동
        binding.arrowHome.setOnClickListener {
            val intent = Intent(this, ProblemList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_exit, R.anim.none)
            finish()
        }
        val check = binding.check
        binding.answerCount.text = App.prefs.getCount("")

        binding.btnGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                binding.secondRadioBtn -> {
                    binding.check.setOnClickListener {
                        val answer = binding.answer
                        answer.visibility = VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.setText(answer_text)
                        binding.correct.setTextColor(Color.parseColor("#46E2F0"))

                        App.prefs.setCount((App.prefs.getCount("").toInt() + 1).toString())
                        binding.answerCount.text = App.prefs.getCount("")

                        App.prefs.setBoolean(checkBoolean, false)
                        binding.check.isEnabled = App.prefs.getBoolean(checkBoolean, true)
                    }
                }
                else -> {
                    binding.check.setOnClickListener {
                        val answer = binding.answer
                        answer.visibility = VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.setText(wrong_answer_text)
                        binding.correct.setTextColor(Color.parseColor("#EFBC9B"))

                        App.prefs.setBoolean(checkBoolean, false)
                        binding.check.isEnabled = App.prefs.getBoolean(checkBoolean, true)
                    }
                    binding.check.isEnabled = App.prefs.getBoolean(checkBoolean, true)
                }
            }
        }
        binding.check.isEnabled = App.prefs.getBoolean(checkBoolean, true)
        //다음문제로 이동
        binding.arrowForward.setOnClickListener {
            //////LastPage
            val intent = Intent(this, eighth::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }
    }
}