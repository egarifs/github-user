package com.firdauscode.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firdauscode.github.databinding.ActivityDetailUserBinding
import com.firdauscode.github.model.User

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val KEY_USER = "key_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>(KEY_USER) as User
        binding.imgPhotoDetail.setImageResource(user.avatar)

        binding.tvFollowers.text = user.followers.toString()
        binding.tvFollowing.text = user.following.toString()
        binding.tvRepository.text = user.repository.toString()
        binding.fullName.text = user.name
        binding.userNameDetail.text = user.username
        binding.locationDetail.text = user.location
        binding.compayDetail.text = user.company
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()

    }
}