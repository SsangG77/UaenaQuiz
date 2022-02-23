package com.example.uaenaquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uaenaquiz.databinding.ActivityProblemListBinding

class ProblemList : AppCompatActivity() {

    lateinit var binding: ActivityProblemListBinding

    private val problems = listOf(
        Problem("1. 아이유의 생년월일은?"),
        Problem("2. 아이유의 데뷔날짜는?"),
        Problem("3. 아이유가 광고중인 소주 이름은?"),
        Problem("4. 라일락의 꽃말은?"),
        Problem("5. 장만월은 무슨띠 일까요??"),
        Problem("6. 아이유가 가장 좋아하는 요일은?"),
        Problem("7. 'Coin'에 카메오로 출연한 배우는?"),
        Problem("8. '이지금'의 작곡가는?"),
        Problem("9. 곡 '자장가'의 모티브가 된 작품은?"),
        Problem("10. 아이유의 어머니가 라식수슬을 한것을 계기로 탄생한 곡은?"),
        Problem("11. 아이유가 어릴때 부모님이 운영했던 문구점의 이름은?"),
        Problem("12. 21년 12월 기준으로 팔레트에 출연하지 않은 게스트는?"),
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
        }
        overridePendingTransition(R.anim.horizon_enter, R.anim.none)
    }

}