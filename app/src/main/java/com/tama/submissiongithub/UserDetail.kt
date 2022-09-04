package com.tama.submissiongithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide


class UserDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail User"

        val data = intent.getParcelableExtra<GitUser>("DATA")
        binding.imgDetail.setImageResource(data?.photo!!.toInt())
        Glide.with(binding.imgDetail)
            .load(data?.photo!!.toInt())
            .circleCrop()
            .into(binding.imgDetail)
        binding.apply {
            tvNameDetail.text = data.name
            tvDescDetail.text = data.description
            tvFollower.text = data.follower
            tvFollowing.text = data.following
            tvFullname.text = data.fullname
            tvCompany.text = data.company
            tvLocation.text = data.location
            tvRepositories.text = data.repositories
        }

    }
}