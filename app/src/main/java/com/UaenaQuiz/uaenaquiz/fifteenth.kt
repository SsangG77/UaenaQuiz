package com.UaenaQuiz.uaenaquiz


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.UaenaQuiz.App
import com.UaenaQuiz.uaenaquiz.databinding.ActivityFifteenthBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

/////////
open class fifteenth : BaseActivity() {
    lateinit var mAdView : AdView
    private var mBinding: ActivityFifteenthBinding? = null
    private val binding get() = mBinding!!
    //애니메이션 객체
    lateinit var fadeInAnim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val checkBoolean : String = fifteenthBoolean

        var answer_text:String = "정답\n" +
                "'[IU TV] 기상청이 그랬어 오늘 '딸기 달' 뜬다고'에서 포도맛이라고 언급한다."
        var wrong_answer_text:String = "오답\n" +
                "'[IU TV] 기상청이 그랬어 오늘 '딸기 달' 뜬다고'에서 포도맛이라고 언급한다."

        //fade in 애니메이션 객체 생성
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.change_activity)

        mBinding = ActivityFifteenthBinding.inflate(layoutInflater)
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

        binding.btnGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                binding.fourthRadioBtn -> {
                    binding.check.setOnClickListener {
                        var answer = binding.answer
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
                        var answer = binding.answer
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
            val intent = Intent(this, sixteenth::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
            finish()
        }
    }
}