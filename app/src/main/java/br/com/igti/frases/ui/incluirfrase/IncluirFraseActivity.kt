package br.com.igti.frases.ui.incluirfrase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.igti.frases.R
import br.com.igti.frases.databinding.ActivityIncluirFraseBinding
import br.com.igti.frases.databinding.ActivityMainBinding

class IncluirFraseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIncluirFraseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncluirFraseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configListeners()
    }

    private fun configListeners() {
        configListenersBtnCancelar()
    }

    private fun configListenersBtnCancelar() {
        binding.btnCancelar.setOnClickListener{
            finish()
        }
    }
}