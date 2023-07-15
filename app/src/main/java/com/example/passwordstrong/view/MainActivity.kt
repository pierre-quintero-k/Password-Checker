package com.example.passwordstrong.view

import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.passwordstrong.R
import com.example.passwordstrong.databinding.ActivityMainBinding
import com.example.passwordstrong.presenter.PasswordStrengthPresenter
import com.example.passwordstrong.presenter.PasswordStrengthView

class MainActivity : AppCompatActivity(), PasswordStrengthView {

    private lateinit var presenter: PasswordStrengthPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter= PasswordStrengthPresenter(this)

        binding.buttonCheckStrength.setOnClickListener{
            val password= binding.editTextPassword.text.toString()
            presenter.onPasswordTextChanged(password)
        }

    }

    override fun showPasswordStrengthLevel(level: Int) {
        Log.w("ATTENTO", "vista estamos regresando con el " + level)
        var texto= binding.textViewPasswordStrength
        var color = R.color.white
         if (level <= 4) {
            color= R.color.red
             texto.setText("WEAK PASSWORD")
            }
        else if ( level >= 5 && level <= 8 ) {
             texto.setText("MEDIUM PASSWORD")
             color= R.color.orange }
        else if ( level >= 9 ) {
             texto.setText("STRONG PASSWORD")
            color= R.color.green }
        else {
             texto.setText("NO LO SE RICK,, PARECE FALSO")
         }

        binding.textViewPasswordStrength.setBackgroundColor(resources.getColor(color))
    }
}