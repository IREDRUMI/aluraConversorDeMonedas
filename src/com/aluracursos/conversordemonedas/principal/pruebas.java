package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.http.Conexionhttp;
import com.aluracursos.conversordemonedas.modelos.conversionMoneda;
import com.aluracursos.conversordemonedas.modelos.monedaExchageApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;




public class pruebas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Conexionhttp nuevaConexion = new Conexionhttp();
        System.out.println(nuevaConexion.getJson());


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();


        monedaExchageApi datos  = gson.fromJson(nuevaConexion.getJson(), monedaExchageApi.class);
        System.out.println(datos);

        conversionMoneda conversion = new conversionMoneda(datos);


        System.out.println(conversion.calculoConversionMoneda("MXN",23,1 ));

        //monedaExchageApi conversionMoneda1 =  gson.fromJson(nuevaConexion.getJson(),monedaExchageApi.class);

       //System.out.println(conversionMoneda1.baseCode());
    }
}
