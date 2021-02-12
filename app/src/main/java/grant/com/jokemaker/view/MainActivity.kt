package grant.com.jokemaker.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import grant.com.jokemaker.adapter.JokeAdapter
import grant.com.jokemaker.databinding.ActivityMainBinding
import grant.com.jokemaker.model.JokeResponse
import grant.com.jokemaker.utils.Constants
import grant.com.jokemaker.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding:ActivityMainBinding
    private var grid = false
    private var type = "Any"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        type = intent.getStringExtra(Constants.JOKE_ACTIVITY_PARAM_TYPE).toString()

        val linearLayoutManager = LinearLayoutManager(this)
        binding.jokeView.layoutManager = linearLayoutManager
        viewModel.getJokes(type, 10)

        viewModel.jokes.observe(this, Observer<JokeResponse> { jokeResponse ->
            var adapter : JokeAdapter = JokeAdapter(jokeResponse.jokes)
            binding.jokeView.adapter = adapter
        })

        binding.layoutBtn.setOnClickListener {
            grid = !grid
            if(grid){
                val gridLayoutManager = GridLayoutManager(this, 2)
                binding.jokeView.layoutManager = gridLayoutManager

            }
            else{
                val linearLayoutManager = LinearLayoutManager(this)
                binding.jokeView.layoutManager = linearLayoutManager
            }

        }


    }
}