package grant.com.jokemaker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import grant.com.jokemaker.databinding.JokeActivityBinding
import grant.com.jokemaker.utils.Constants

class JokeActivity : AppCompatActivity() {

    lateinit var binding : JokeActivityBinding
    private var jokeDelivery : String? = "To get to the other side"
    private var jokeSetup:String? = "Why did the chicken cross the road?"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = JokeActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        jokeDelivery = intent.getStringExtra(Constants.JOKE_DELIVERY_STRING)
        jokeSetup = intent.getStringExtra(Constants.JOKE_SETUP_STRING)
        if(jokeSetup.equals("SETUP")){
            binding.deliveryText.text = jokeDelivery
        }else{
            binding.deliveryText.text = jokeDelivery
            binding.setupText.text = jokeSetup
        }


    }
}