package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailInput = findViewById<EditText>(R.id.editEmail)
        val firstNameInput = findViewById<EditText>(R.id.editFirstName)
        val lastNameInput = findViewById<EditText>(R.id.editLastName)
        val passwordInput = findViewById<EditText>(R.id.editPassword)
        val repeatPasswordInput = findViewById<EditText>(R.id.repeatPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSubmit.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val firstName = firstNameInput.text.toString().trim()
            val lastName = lastNameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val repeatPassword = repeatPasswordInput.text.toString().trim()

            if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                password.isEmpty() || repeatPassword.isEmpty()
            ) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
            } else if (password != repeatPassword) {
                Toast.makeText(this, "Password tidak sama!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            emailInput.text.clear()
            firstNameInput.text.clear()
            lastNameInput.text.clear()
            passwordInput.text.clear()
            repeatPasswordInput.text.clear()

            Toast.makeText(this, "Input dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}
