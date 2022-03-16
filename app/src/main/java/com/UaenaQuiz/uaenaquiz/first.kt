package com.UaenaQuiz.uaenaquiz

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import com.UaenaQuiz.App
import com.UaenaQuiz.uaenaquiz.databinding.ActivityFirstBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class first : BaseActivity() {
    lateinit var mAdView : AdView
    private var mBinding: ActivityFirstBinding? = null
    private val binding get() = mBinding!!
    //애니메이션 객체
    lateinit var fadeInAnim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val checkBoolean : String = firstBoolean

        val answer_text: String = "정답\n" +
                "아이유의 생년월일은 1993년 5월 16일 일요일에 태어났다."
        val wrong_answer_text: String = "오답\n" +
                "아이유의 생년월일은 1993년 5월 16일 일요일에 태어났다."

        mBinding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fade in 애니메이션 객체 생성
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.change_activity)

        //AD 관련 설정
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = adUnitId
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //문제 리스트 화면으로 이동
        binding.arrowHome.setOnClickListener {
            val intent = Intent(this, ProblemList::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_exit, R.anim.none)
            finish()
        }

        //SharedPreferences 설정
        binding.answerCount.text = App.prefs.getCount("")

        //보기 관련 코드
        binding.btnGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                binding.firstRadioBtn -> { //정답 보기를 선택했을때
                    binding.check.setOnClickListener {
                        binding.answer.visibility = View.VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.text = answer_text
                        binding.correct.setTextColor(Color.parseColor("#46E2F0"))

                        //SharedPreference 설정
                        App.prefs.setCount((App.prefs.getCount("0").toInt() + 1).toString())
                        binding.answerCount.text = App.prefs.getCount("")

                        App.prefs.setBoolean(checkBoolean, false)
                        binding.check.isEnabled = App.prefs.getBoolean(checkBoolean, true)
                    }

                }

                else -> { //정답이 아닌 보기를 선택했을때
                    binding.check.setOnClickListener {
                        binding.answer.visibility = View.VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.text = wrong_answer_text
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
            val intent = Intent(this, second::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }
    }
}
