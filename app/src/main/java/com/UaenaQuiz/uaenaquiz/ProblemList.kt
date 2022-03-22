package com.UaenaQuiz.uaenaquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.UaenaQuiz.uaenaquiz.databinding.ActivityProblemListBinding

class ProblemList : AppCompatActivity() {

    lateinit var binding: ActivityProblemListBinding

    private val problems = listOf(
        Problem("1. 아이유의 생년월일은?"),
        Problem("2. 아이유의 데뷔날짜는?"),
        Problem("3. 아이유가 광고중인 소주 이름은?"),
        Problem("4. 라일락의 꽃말은?"),
        Problem("5. 장만월은 무슨띠 일까요?"),
        Problem("6. 아이유가 가장 좋아하는 요일은?"),
        Problem("7. 'Coin'에 카메오로 출연한 배우는?"),
        Problem("8. '이지금'의 작곡가는?"),
        Problem("9. 곡 '자장가'의 모티브가 된 작품은?"),
        Problem("10. 아이유의 어머니가 라식수술을 한것을 계기로 탄생한 곡은?"),
        Problem("11. 아이유가 어릴때 부모님이 운영했던 문구점의 이름은?"),
        Problem("12. 21년 12월 기준으로 팔레트에 출연하지 않은 게스트는?"),
        Problem("13. 아이유가 어릴때 화채를 만들때 넣는 음료는?"),
        Problem("14. 아이유의 신발 사이즈는?"),
        Problem("15. strawberry moon MV에 나오는 아이스크림의 맛은?"),
        Problem("16. '밤편지,'잊어야 한다는 마음으로'에 나오는 여자주인공의 이름은?"),
        Problem("17. 아이유의 MBTI는?"),
        Problem("18. 나의아저씨 '이지안'의 이름 뜻은?"),
        Problem("19. '최고다 이순신'에서 이순신의 생년월일은?"),
        Problem("20. 아이유의 자작곡이 아닌곡은?"),
        Problem("21. 아이유가 앰버서더로 선정된 브랜드는?"),
        Problem("22. 아이유의 혈핵형은?"),
        Problem("23. 아이유가 광고했던 교복 브랜드는?"),
        Problem("24. 아이유의 첫 고정예능은?"),
        Problem("25. 아이유가 첫 1위한 곡은?"),
        Problem("26. 꽃갈피의 타이틀곡은?"),
        Problem("27. 아이유의 첫 연기 데뷔작은?"),
        Problem("28. god의 곡중 아이유가 피처링한 곡은?"),
        Problem("29. 첫 OST로 참여한 작품의 이름은?"),
        Problem("30. 아이유가 연기로 여자 신인상을 받을 수 있었던 작품은?"),
        Problem("31. 아이유의 최애템은?"),
        Problem("32. 보통이의 극중 나이는?"),
        Problem("33. 아이유가 좋아하는 디즈니캐릭터는?"),
        Problem("34. 아이유가 자신있어하는 신체부위는?"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problem_list)

        binding = ActivityProblemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.horizon_exit, R.anim.none)
            finish()
        }

        binding.problemList.layoutManager = LinearLayoutManager(this)
        binding.problemList.adapter = ProblemRecyclerViewAdpater(problems) { position -> onListItemClick(position) }

        }
    fun onListItemClick(position : Int) {
        when(position) {
            0 -> startActivity(Intent(this, first::class.java))
            1 -> startActivity(Intent(this, second::class.java))
            2 -> startActivity(Intent(this, third::class.java))
            3 -> startActivity(Intent(this, fourth::class.java))
            4 -> startActivity(Intent(this, fifth::class.java))
            5 -> startActivity(Intent(this, sixth::class.java))
            6 -> startActivity(Intent(this, seventh::class.java))
            7 -> startActivity(Intent(this, eighth::class.java))
            8 -> startActivity(Intent(this, ninth::class.java))
            9 -> startActivity(Intent(this, tenth::class.java))
            10 -> startActivity(Intent(this, eleventh::class.java))
            11 -> startActivity(Intent(this, twelfth::class.java))
            12 -> startActivity(Intent(this, thirteenth::class.java))
            13 -> startActivity(Intent(this, fourteenth::class.java))
            14 -> startActivity(Intent(this, fifteenth::class.java))
            15 -> startActivity(Intent(this, sixteenth::class.java))
            16 -> startActivity(Intent(this, seventeenth::class.java))
            17 -> startActivity(Intent(this, eighteenth::class.java))
            18 -> startActivity(Intent(this, nineteenth::class.java))
            19 -> startActivity(Intent(this, twentieth::class.java))
            20 -> startActivity(Intent(this, twentyFirst::class.java))
            21 -> startActivity(Intent(this, twentySecond::class.java))
            22 -> startActivity(Intent(this, twentyThird::class.java))
            23 -> startActivity(Intent(this, twentyFourth::class.java))
            24 -> startActivity(Intent(this, twentyFifth::class.java))
            25 -> startActivity(Intent(this, twentySixth::class.java))
            26 -> startActivity(Intent(this, twentySeventh::class.java))
            27 -> startActivity(Intent(this, twentyEighth::class.java))
            28 -> startActivity(Intent(this, twentyNinth::class.java))
            29 -> startActivity(Intent(this, thirtieth::class.java))
            30 -> startActivity(Intent(this, thirtyFirst::class.java))
            31 -> startActivity(Intent(this, thirtySecond::class.java))
            32 -> startActivity(Intent(this, thirtyThird::class.java))

        }
        overridePendingTransition(R.anim.horizon_enter, R.anim.none)
    }

}