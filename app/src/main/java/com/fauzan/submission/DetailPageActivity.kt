package com.fauzan.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fauzan.submission.databinding.ActivityDetailPageBinding

class DetailPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPageBinding
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = binding.imageView
        val tvDetailUser = binding.tvDetailUser
        val tvDetailName = binding.tvDetailName
        val tvDetailLoc = binding.tvDetailLocation
        val tvDetailComp = binding.tvDetailCompany
        val tvDetailRepo = binding.tvDetailRepo
        val tvDetailFollowers = binding.tvDetailFollowers
        val tvDetailFollowing = binding.tvDetailFollowing

        val user = intent.getParcelableExtra<DataUser>(EXTRA_USER) as DataUser
        val actionbar = supportActionBar
        supportActionBar?.title = user.name
        imageView.setImageResource(user.avatar)
        tvDetailUser.text = resources.getString(R.string.userplaceholder, user.username)
        tvDetailName.text = user.name
        tvDetailLoc.text = user.location
        tvDetailComp.text = user.company
        tvDetailRepo.text = resources.getString(R.string.repoplaceholder, user.repo)
        tvDetailFollowers.text = resources.getString(R.string.followerplaceholder, user.followers)
        tvDetailFollowing.text = resources.getString(R.string.followingplaceholder, user.following)

        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}