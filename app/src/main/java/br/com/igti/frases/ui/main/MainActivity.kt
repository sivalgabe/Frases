package br.com.igti.frases.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import br.com.igti.frases.data.Frase
import br.com.igti.frases.databinding.ActivityMainBinding
import br.com.igti.frases.ui.incluirfrase.IncluirFraseActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val retornoFrase = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if ( activityResult.resultCode == RESULT_OK) {
            activityResult.data?.let {
                if (it.hasExtra(RETORNO)){
                    Log.i("IGTIinfo", "Retorno: ${it.getParcelableExtra<Frase>(RETORNO)}")
                }
            }
        } else {
            Log.e("IGTIerror:","Não foi possível obter os dados de retorno da activity.")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        configListeners()
    }

    private fun configListeners() {
        configFabListeners()
    }

    private fun configFabListeners() {
        binding.fabAddNovaFrase.setOnClickListener{
            val intent = Intent(this, IncluirFraseActivity::class.java).let {
                retornoFrase.launch(it)
            }
        }
    }

    companion object {
        const val RETORNO = "retorno_frases"
    }
}