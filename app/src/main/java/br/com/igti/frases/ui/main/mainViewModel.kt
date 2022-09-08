package br.com.igti.frases.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.igti.frases.data.Frase
import br.com.igti.frases.data.repository.MemoryRepository

class mainViewModel: ViewModel() {
    private var memoryRepository: MemoryRepository = MemoryRepository(mutableListOf())
    private val _listaDeFrases = MutableLiveData<List<Frase>>()

    val listaDeFrases: LiveData<List<Frase>> = _listaDeFrases

    fun iniciarDados() {
        _listaDeFrases.value = memoryRepository.retornarLista()
    }

    fun salvarFrase(frase: Frase) {
        Log.i("IGTIinfo","Frase recebida: $frase")

        memoryRepository.salvar(frase)
        atualizarListaFrases()
    }

    fun limparListaDeFrases() {
        Log.i("IGTIinfo","Iniciando limpeza do repositório")
        memoryRepository.limparLista()
        atualizarListaFrases()
    }

    private fun atualizarListaFrases() {
        _listaDeFrases.value = memoryRepository.retornarLista()
    }
}