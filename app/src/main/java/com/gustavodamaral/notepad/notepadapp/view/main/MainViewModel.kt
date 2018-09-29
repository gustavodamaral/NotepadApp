package com.gustavodamaral.notepad.notepadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gustavodamaral.notepad.notepadapp.model.Nota
import com.gustavodamaral.notepad.notepadapp.repository.NotaRepository

class MainViewModel : ViewModel() {

    val notaRepository = NotaRepository()

    val notas: MutableLiveData<List<Nota>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()


    fun buscarTodos(){
        isLoading.value = true
        notaRepository.buscarTodos(
                onComplete = {
                    isLoading.value = false
                    notas.value = it
                }, onError = {
                    isLoading.value = false
                    notas.value = arrayListOf()
                }
        )
    }

}