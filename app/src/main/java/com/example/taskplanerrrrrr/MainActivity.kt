package com.example.taskplanerrrrrr

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.Toast
import com.example.taskplanerrrrrr.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth : Button
    private lateinit var bindig : ActivityMainBinding
    private lateinit var Firebase : FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        auth = findViewById(R.id.AuthButton)
        Firebase = FirebaseAuth.getInstance()
        auth.setOnClickListener {
            val email = bindig.Email.text.toString()
            val pass = bindig.Password.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                Firebase.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        val menuTabs = Intent(this, TabsMenu::class.java)
                        startActivity(menuTabs)
                    }
                    else {
                        Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else {
                Toast.makeText(this, "Некоректный ввод данных", Toast.LENGTH_SHORT).show()
            }

        }

    }
}