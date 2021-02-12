package grant.com.jokemaker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import grant.com.jokemaker.model.Joke
import grant.com.jokemaker.model.JokeResponse
import grant.com.jokemaker.repo.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _jokes = MutableLiveData<JokeResponse>()
    val jokes:LiveData<JokeResponse> = _jokes

    fun getJokes(type : String, amount:Int){
        viewModelScope.launch(Dispatchers.IO) {
            _jokes.postValue(JokeRepository.getJokes(type,amount))
        }
    }
}