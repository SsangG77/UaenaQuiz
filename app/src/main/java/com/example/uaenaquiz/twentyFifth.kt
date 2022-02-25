package com.example.uaenaquiz


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.uaenaquiz.databinding.ActivityTwentyFifthBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

/////////
open class twentyFifth : BaseActivity() {

    lateinit var mAdView : AdView

    val TAG: String = "로그"

    private var mBinding: ActivityTwentyFifthBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    //애니메이션 객체
    lateinit var fadeInAnim : Animation

    override fun onCreate(savedInstanceState: Bundle?) {

        var answer_text:String = "정답\n" +
                "2010년 6월 25일 뮤직뱅크에서 '잔소리'로 처음으로 1위를 하였다."
        var wrong_answer_text:String = "오답\n" +
                "2010년 6월 25일 뮤직뱅크에서 '잔소리'로 처음으로 1위를 하였다."

        var setview = setContentView(R.layout.activity_twenty_fifth)


        //fade in 애니메이션 객체 생성
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.change_activity)

        super.onCreate(savedInstanceState)
        setview
        mBinding = ActivityTwentyFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        var answerCount = Integer.parseInt(intent.getIntExtra("answer",0).toString())
        binding.answerCount.text = answerCount.toString()


        //선택한 보기와 정답보기가 일치하는지 확인
        //선택된 라디오버튼의 id가 정답 아이디와 일치하면 정답, 그렇지 않으면 오답
        binding.btnGroup.setOnCheckedChangeListener { _, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            when (radio) {
                binding.secondRadioBtn -> {
                    binding.check.setOnClickListener {
                        var answer = binding.answer
                        answer.visibility = VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.setText(answer_text)
                        binding.correct.setTextColor(Color.parseColor("#46E2F0"))
                        check.isEnabled = false

                        //다음문제로 이동
                        binding.arrowForward.setOnClickListener {
                            val intent = Intent(this, twentySixth::class.java)
                            intent.putExtra("answer",  answerCount+1)
                            startActivity(intent)
                            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
                            finish()
                        }
                    }
                }
                else -> {
                    binding.check.setOnClickListener {
                        var answer = binding.answer
                        answer.visibility = VISIBLE
                        binding.answer.startAnimation(fadeInAnim)
                        binding.correct.setText(wrong_answer_text)
                        binding.correct.setTextColor(Color.parseColor("#EFBC9B"))
                        check.isEnabled = false

                        //다음문제로 이동
                        binding.arrowForward.setOnClickListener {
                            val intent = Intent(this, twentySixth::class.java)
                            intent.putExtra("answer", answerCount+0)
                            startActivity(intent)
                            overridePendingTransition(R.anim.horizon_enter, R.anim.none)
                            finish()
                        }
                    }
                }
            }
        }


    }
}