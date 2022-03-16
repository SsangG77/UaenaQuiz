package com.UaenaQuiz.uaenaquiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.UaenaQuiz.uaenaquiz.databinding.ProblemBinding

class ProblemRecyclerViewAdpater(private var problems:List<Problem>, private val onItemClicked: (position:Int) -> Unit) : RecyclerView.Adapter<ProblemRecyclerViewAdpater.ProblemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ProblemViewHolder {
        return ProblemViewHolder(ProblemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClicked)
    }

    override fun onBindViewHolder(holder: ProblemViewHolder, position: Int) {
        holder.bind(problems[position])
    }

    override fun getItemCount(): Int { return problems.size }

    class ProblemViewHolder(
        private var binding: ProblemBinding,
        private val onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(problem: Problem) {
            binding.problemItem.text = problem.title
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            onItemClicked(position)
        }

    }


}