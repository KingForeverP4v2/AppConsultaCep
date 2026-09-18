package com.example.appconsultacep.Api

import com.example.appconsultacep.Model.ResponceEndereco
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("/ws/{cep}/json/")
    suspend fun buscarEndereco(
        @Path("cep")cep: String
    ) : ResponceEndereco
}