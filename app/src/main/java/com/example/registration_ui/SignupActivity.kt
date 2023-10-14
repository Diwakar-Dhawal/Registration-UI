package com.example.registration_ui

import android.R.attr.password
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.text.method.SingleLineTransformationMethod
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registration_ui.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signupLogin.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.signupCnfPassword.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.signupCnfPassword.setTransformationMethod(SingleLineTransformationMethod())
            } else {
                binding.signupCnfPassword.setTransformationMethod(PasswordTransformationMethod())
            }
            // move cursor to end of text
            binding.signupCnfPassword.setSelection(binding.signupCnfPassword.getText().length)
        }
        binding.signupBtn.setOnClickListener{
            if(validate(binding.signupName.text.toString(), binding.signupEmail.text.toString(),binding.signupPassword.text.toString(),binding.signupCnfPassword.text.toString(),binding.signupPhone.text.toString()))
            {
                Toast.makeText(this@SignupActivity,"Signup Success",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun validate(name:String,email:String, pass:String, cnfpass:String, phone:String):Boolean
    {
        if(name.isEmpty())
        {
            binding.signupName.setError("Name Cannot be Empty")
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.signupEmail.setError("Enter a valid email")
            return false
        }

        if(phone.length!=10 || !phone.matches(Regex("^[0-9]*$")))
        {
            binding.signupPhone.setError("Enter a valid Phone Number")
            return false
        }
        if(pass.length<6)
        {
            binding.signupPassword.setError("Minimum length of Password should be 6")
            return false
        }
        if(!cnfpass.equals(pass))
        {
            binding.signupCnfPassword.setError("Confirm password should be same as entered password")
            return false
        }
        return true
    }
}