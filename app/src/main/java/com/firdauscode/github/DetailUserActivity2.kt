package com.firdauscode.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.firdauscode.github.databinding.ActivityDetailUser2Binding
import com.firdauscode.github.model.User

class DetailUserActivity2 : AppCompatActivity() {

    companion object{
        const val DATA_INTENT_USER = "DATA_INTENT_USER"
    }

    private lateinit var binding: ActivityDetailUser2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUser2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent.getParcelableExtra<User>(DATA_INTENT_USER)
        dataIntent?.let {
            title = it.name
            binding.run {
                fullNameDetail.visibility = View.VISIBLE
                fullNameDetail.text = it.name
                Glide.with(this@DetailUserActivity2).load(it.avatar).into(imgPhotoDetail)
            }
        }

        /*val text  = "Name : ${name?.name},"
        binding.tvDetailDua.text = text*/


    }
}