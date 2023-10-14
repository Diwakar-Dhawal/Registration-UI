package com.example.registration_ui

import android.R.attr.logo
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.example.registration_ui.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginCreate.setOnClickListener {
            var intent = Intent(this,SignupActivity::class.java)
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@LoginActivity, binding.loginLogo, "logo_transition"
                )

            startActivity(intent,optionsCompat.toBundle())
        }
        binding.loginBtn.setOnClickListener {
            if(validate(binding.loginEmail.text.toString(),binding.loginPassword.text.toString()))
            {
                Toast.makeText(this@LoginActivity,"Login Success",Toast.LENGTH_LONG).show()
            }

        }



    }
    private fun validate(email:String,pass:String): Boolean
    {

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Log.d("TAG", "validate: "+email)
            binding.loginEmail.setError("Invalid Email")
            return false;
        }
        else if(pass.length<1)
        {
            binding.loginPassword.setError("Password cannot be empty")
            return false;
        }
        return true;
    }
}