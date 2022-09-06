package br.com.igti.frases.ui.incluirfrase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.igti.frases.R
import br.com.igti.frases.data.Frase
import br.com.igti.frases.databinding.ActivityIncluirFraseBinding
import br.com.igti.frases.databinding.ActivityMainBinding
import br.com.igti.frases.ui.main.MainActivity

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
        configListenersBtnSalvar()
    }

    private fun configListenersBtnSalvar() {
        binding.btnSalvar.setOnClickListener{
            salvarFrase()
        }
    }

    private fun salvarFrase() {
        val autor = binding.autoresFraseED.text.toString()
        val frase = binding.frasesET.text.toString()

        if(autor.isEmpty()) {
            binding.autoresFraseTIL.error = getString(R.string.tvErroSemAutor)
        } else {
            binding.autoresFraseTIL.error = null
        }

        if (frase.isEmpty()) {
            binding.FraseTIL.error = getString(R.string.tvErrorSemFrase)
        } else {
            binding.FraseTIL.error = null
        }

        if (autor.isNotEmpty() && frase.isNotEmpty()) {
            Log.i("IGTIinfo","Autor: $autor, Frase: $frase")
            Intent().apply {
                putExtra(MainActivity.RETORNO, Frase(
                    autor = autor,
                    frase = frase
                ))
                setResult(RESULT_OK, this)
            }
            finish()
        } else {
            Log.i("IGTIinfo","Dados não Salvos, os campos estavam vazios")
        }
    }

    private fun configListenersBtnCancelar() {
        binding.btnCancelar.setOnClickListener{
            finish()
        }
    }
}