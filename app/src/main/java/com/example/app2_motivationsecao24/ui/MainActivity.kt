package com.example.app2_motivationsecao24.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.app2_motivationsecao24.infra.MotivationConstants
import com.example.app2_motivationsecao24.R
import com.example.app2_motivationsecao24.infra.SecurityPreferences
import com.example.app2_motivationsecao24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instancia a classe e infla (expande) o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Atribui o binding para a view
        setContentView(binding.root)

        //Esconde barra de navegação
        supportActionBar?.hide()

        //Define o nome da saudação
        handleUserName()

        //Deixa como default o infinite selecionado
        handleFilter(R.id.image_all)

        //Eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_new_phrase) {
            var s = ""
        }else if(v.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
            handleFilter(v.id)
        }
    }

    private fun handleFilter(id: Int){

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    fun handleUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }
}

