package com.example.uaenaquiz

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.uaenaquiz.databinding.ActivitySixthBinding


import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

/////////
open class sixth : BaseActivity() {

    lateinit var mAdView : AdView

    val TAG: String = "로그"

    //////
    private var mBinding: ActivitySixthBinding? = null

    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    //애니메이션 객체
    lateinit var fadeInAnim : Animation


    override fun onCreate(savedInstanceState: Bundle?) {

        var answer_text:String = "정답\n" +
                "[IU TV]-이지금에게 물어봐 편에 장만월이 직접 대답한다."
        var wrong_answer_text:String = "오답\n" +
                "[IU TV]-이지금에게 물어봐 편에 장만월이 직접 대답한다."

        var setview = setContentView(R.layout.activity_sixth)



        //fade in 애니메이션 객체 생성
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.change_activity)

        super.onCreate(savedInstanceState)
        setview
        mBinding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //메인화면창으로 이동
        binding.arrowHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
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
                ///////RadioBtn
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
                            //////LastPage
                            val intent = Intent(this, seventh::class.java)
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
                            //////LastPage
                            val intent = Intent(this, seventh::class.java)
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