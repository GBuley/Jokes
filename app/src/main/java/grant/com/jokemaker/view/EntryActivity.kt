package grant.com.jokemaker.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import grant.com.jokemaker.R
import grant.com.jokemaker.databinding.EntryActivityBinding
import grant.com.jokemaker.utils.Constants
import grant.com.jokemaker.viewModel.EntryViewModel

class EntryActivity : AppCompatActivity() {
    private val viewModel by viewModels<EntryViewModel>()
    private lateinit var binding: EntryActivityBinding
    private lateinit var type:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EntryActivityBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.jokeBtn.setOnClickListener {
            goToNextActivity()
        }

    }




    private fun goToNextActivity() {
        var typeOfJoke :String = ""

        fun checkCheckBoxes() : String{
            var typeOfJoke:String = ""
            if(binding.typeAny.isChecked){
                if(typeOfJoke.isEmpty())
                {
                    typeOfJoke = "Any"
                }else {
                    typeOfJoke += ",Any"
                }
            }
            if(binding.typeChristmas.isChecked){
                if(typeOfJoke.isEmpty()){
                    typeOfJoke = "Christmas"
                }else{
                    typeOfJoke += ",Christmas"
                }
            }
            if(binding.typeDark.isChecked){
                if(typeOfJoke.isEmpty()) {
                    typeOfJoke = "Dark"
                }else {
                    typeOfJoke += ",Dark"
                }
            }
            if(binding.typeMisc.isChecked){
                if(typeOfJoke.isEmpty()){
                    typeOfJoke = "Miscellaneous"
                }
                else {
                    typeOfJoke += ",Miscellaneous"
                }
            }
            if(binding.typeProgramming.isChecked){
                if(typeOfJoke.isEmpty()){
                    typeOfJoke = "Programming"
                }else{
                    typeOfJoke += ",Programming"
                }
            }
            if(binding.typePun.isChecked){
                if(typeOfJoke.isEmpty()){
                    typeOfJoke ="Pun"
                }
                else {
                    typeOfJoke += ",Pun"
                }
            }
            if(binding.typeSpooky.isChecked){
                if(typeOfJoke.isEmpty()){
                    typeOfJoke = "Spooky"
                }
                else {
                    typeOfJoke += ",Spooky"
                }
            }
            return typeOfJoke
        }
        typeOfJoke = checkCheckBoxes()

        if(typeOfJoke.isBlank()){
            typeOfJoke = "Any"
        }

        val intent = Intent(this@EntryActivity, MainActivity::class.java)

        intent.putExtra(Constants.JOKE_ACTIVITY_PARAM_TYPE, typeOfJoke)
        startActivity(intent)



    }
}