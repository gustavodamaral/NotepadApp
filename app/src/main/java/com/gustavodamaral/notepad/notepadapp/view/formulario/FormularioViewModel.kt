package com.gustavodamaral.notepad.notepadapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.gustavodamaral.notepad.notepadapp.model.Nota
import com.gustavodamaral.notepad.notepadapp.model.ResponseStatus
import com.gustavodamaral.notepad.notepadapp.repository.NotaRepository

class FormularioViewModel: ViewModel(){

    val notaRepository = NotaRepository()

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    fun salvar(titulo: String, descricao: String){

        val nota = Nota(null,titulo,descricao)

        notaRepository.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true, "foi")
                },
                onError = {
                    responseStatus.value = ResponseStatus(false, it?.message!!)
                })

    }

}