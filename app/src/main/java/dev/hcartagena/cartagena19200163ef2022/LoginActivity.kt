package dev.hcartagena.cartagena19200163ef2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtEmail: EditText = findViewById(R.id.tvemail)
        val txtPassword: EditText = findViewById(R.id.tvuser)
        val btnLogin: Button = findViewById(R.id.btnlogin)
        val db = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            val correo = txtEmail.text.toString()
            val clave = txtPassword.text.toString()

            db.signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Inicio satisfactorio", Toast.LENGTH_LONG).show()
                        startActivity( Intent(this,MainActivity::class.java))
                    }else{
                        Toast.makeText(this,"Usuario y/o Email no existe", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}