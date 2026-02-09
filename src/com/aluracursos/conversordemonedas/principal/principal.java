package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.http.Conexionhttp;
import com.aluracursos.conversordemonedas.modelos.conversionMoneda;
import com.aluracursos.conversordemonedas.modelos.monedaExchageApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conexionhttp nuevaConexion = new Conexionhttp();
        System.out.println(nuevaConexion.getJson());
        

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        System.out.println(gson);

        monedaExchageApi conversionMoneda1 =  gson.fromJson(nuevaConexion.getJson(),monedaExchageApi.class);

//        System.out.println("USD rate: " + conversionMoneda1.usdRate());
//
//        System.out.println("CODE BASE: " + conversionMoneda1.baseCode());
//        System.out.println("USD rate: " + conversionMoneda1.rates().get("MXN"));

 //       System.out.println(conversionMoneda1);
    }
}