package grant.com.jokemaker.adapter

import android.content.Intent
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import grant.com.jokemaker.databinding.ItemJokeBinding
import grant.com.jokemaker.model.Joke
import grant.com.jokemaker.utils.Constants
import grant.com.jokemaker.view.JokeActivity

class JokeAdapter(private var jokes : List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding:ItemJokeBinding = ItemJokeBinding.inflate(LayoutInflater.from(parent.context))
        return JokeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.load(jokes.get(position))
    }

    class JokeViewHolder(private var binding: ItemJokeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun load(joke:Joke){
            if(joke.type.equals("single")){
                binding.tvJoke.text = joke.joke
                binding.tvJokeType.text = joke.type
                binding.jokeEnd.text = joke.joke
            }else{
                binding.tvJoke.text = joke.setup
                binding.jokeEnd.text = joke.delivery
                binding.tvJokeType.text = joke.type
            }
            binding.tvJoke.setOnLongClickListener{
                binding.jokeEnd.visibility = View.VISIBLE
                binding.tvJoke.visibility = View.INVISIBLE
                binding.tvJokeType.visibility = View.INVISIBLE
                return@setOnLongClickListener true
            }
            binding.jokeEnd.setOnLongClickListener{
                binding.jokeEnd.visibility = View.INVISIBLE
                binding.tvJoke.visibility = View.VISIBLE
                binding.tvJokeType.visibility = View.VISIBLE
                return@setOnLongClickListener true
            }
            binding.tvJoke.setOnClickListener{
                val intent = Intent(binding.root.context, JokeActivity::class.java)
                if(joke.type.equals("single")) {
                    intent.putExtra(Constants.JOKE_DELIVERY_STRING, binding.tvJoke.text.toString())
                    binding.root.context.startActivity(intent)
                }
                else{
                    intent.putExtra(Constants.JOKE_SETUP_STRING, binding.tvJoke.text.toString())
                    intent.putExtra(Constants.JOKE_DELIVERY_STRING, binding.jokeEnd.text.toString())
                    binding.root.context.startActivity(intent)
                }
            }
            binding.jokeEnd.setOnClickListener{
                val intent = Intent(binding.root.context, JokeActivity::class.java)
                if(joke.type.equals("single")) {
                    intent.putExtra(Constants.JOKE_DELIVERY_STRING, binding.tvJoke.text.toString())
                    binding.root.context.startActivity(intent)
                }
                else{
                    intent.putExtra(Constants.JOKE_SETUP_STRING, binding.tvJoke.text.toString())
                    intent.putExtra(Constants.JOKE_DELIVERY_STRING, binding.jokeEnd.text.toString())
                    binding.root.context.startActivity(intent)
                }
            }
        }
    }
}