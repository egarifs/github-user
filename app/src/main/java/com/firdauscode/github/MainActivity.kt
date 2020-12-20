package com.firdauscode.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.firdauscode.github.databinding.ActivityMainBinding
import com.firdauscode.github.model.SearchModel
import com.firdauscode.github.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //LogCat
    private val TAG: String = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<SearchModel>()
    //private var users = arrayListOf<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.rvUser.setHasFixedSize(true)

    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi() {
        ApiService.endpoint.getSearchUser()

            .enqueue(object : Callback<SearchModel> {
                override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {
                    if (response.isSuccessful) {
                        showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<SearchModel>, t: Throwable) {
                    printLog(t.toString())
                }

            })

    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }

    private fun showData(data: SearchModel) {
        val item = data.items
        for (items in item) {
            printLog("login ${items.login}")
        }
    }


}


