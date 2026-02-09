package com.aluracursos.conversordemonedas.modelos;

import com.aluracursos.conversordemonedas.http.Conexionhttp;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.Map;

public class conversionMoneda{
    private String monedaBase;
    private double codigoMonedaAConvertir;
    private double valorMonedaAConvertir;
    Map<String, Double> rates;


        public conversionMoneda(monedaExchageApi miMonedaExchangeApi) throws IOException, InterruptedException {
            this.rates = miMonedaExchangeApi.rates();
            //this.valorMonedaAConvertir = miMonedaExchangeApi.rates().get("MXN");
            this.monedaBase = miMonedaExchangeApi.baseCode();
        }

        public  {}


   @Override
   public String toString() {
        return "conversionMoneda{" +
                "monedaBase='" + monedaBase +
                    "conversion rates: " + rates;}
// + '\'' +
//                ", valorMonedaAConvertir=" + valorMonedaAConvertir +
//                ", codigoMonedaAConvertir='" + codigoMonedaAConvertir + '\'' +
//                '}';
//    }
}
