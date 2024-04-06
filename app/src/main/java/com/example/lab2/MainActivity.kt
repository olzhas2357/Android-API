package com.example.lab2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.API.ApiClient
import com.example.lab2.adapter.HistoricalAdapter
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.Historical
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: HistoricalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.instance
        val response = client?.fetchHistoricalList("musician")

        adapter = HistoricalAdapter()

        binding.rcview.adapter = adapter
        binding.rcview.layoutManager = LinearLayoutManager(this)


        response?.enqueue(object : Callback<List<Historical>> {
            override fun onResponse(
                call: Call<List<Historical>>,
                response: Response<List<Historical>>
            ) {
                response.body()?.let {
                    adapter.submitList(it)
                }
            }
            override fun onFailure(call: Call<List<Historical>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}