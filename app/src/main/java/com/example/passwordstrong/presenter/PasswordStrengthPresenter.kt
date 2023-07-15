package com.example.passwordstrong.presenter

import android.util.Log
import com.example.passwordstrong.model.PasswordStrengthChecker

class PasswordStrengthPresenter(private val view: PasswordStrengthView) {
    private val passwordStrengthChecker = PasswordStrengthChecker()

    fun onPasswordTextChanged(password: String){
        Log.w("ATTENTO", "presenter estamos llegando con el password" + password)
        val strengthLevel = passwordStrengthChecker.checkPasswordStrength(password)
        Log.w("ATTENTO", "presenter estamos regresando  con el " + strengthLevel)
        view.showPasswordStrengthLevel(strengthLevel)
    }
}