package com.gustavodamaral.notepad.notepadapp.api

import com.gustavodamaral.notepad.notepadapp.model.Nota
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NotaAPI {

    @GET("/nota/listar")
    fun buscarTodos(): Call<List<Nota>>

    @GET("/nota/titulo/{titulo}")
    fun buscarPorTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/nota")
    fun salvar(nota: Nota): Call<Nota>

    @DELETE("/nota/{id}")
    fun apagar(@Path("/nota/{id}") id: String): Call<Void>

}