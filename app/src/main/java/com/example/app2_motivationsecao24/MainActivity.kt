package com.example.app2_motivationsecao24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.app2_motivationsecao24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instancia a classe e infla (expande) o layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Atribui o binding para a view
        setContentView(binding.root)

        //Esconde barra de navegação
        supportActionBar?.hide()

        handleUserName()

        //Eventos
        binding.buttonNewPhrase.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_new_phrase) {
            var s = ""
        }
    }

    fun handleUserName(){
        val name = SecurityPreferences(this).getString("USER_NAME")
        binding.textUserName.text = "Olá, $name!"
    }
}

