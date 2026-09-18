package com.example.appconsultacep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.example.appconsultacep.Api.ViaCepClient
import kotlinx.coroutines.launch

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
        val edtCep = findViewById<EditText>(R.id.edtCep)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)
        val txtLogradouro = findViewById<EditText>(R.id.txtLogradouro)
        val txtBairro = findViewById<EditText>(R.id.txtBairro)
        val txtUf = findViewById<EditText>(R.id.txtUF)
        val txtLocal = findViewById<EditText>(R.id.txtCidade)
        val txtDDD = findViewById<EditText>(R.id.txtDDD)
        btnConsultar.setOnClickListener {
           val cep = edtCep.text.toString()
            if (cep.length != 8){
                edtCep.error = "CEP inválido"
                edtCep.requestFocus()
                return@setOnClickListener
            }
            lifecycleScope.launch {
                val endereco = ViaCepClient.instance.buscarEndereco(cep)
                txtLogradouro.setText(endereco.logradouro)
                txtBairro.setText(endereco.bairro)
                txtUf.setText(endereco.uf)
                txtLocal.setText(endereco.localidade)
                txtDDD.setText(endereco.ddd)
            }
        }
    }
}