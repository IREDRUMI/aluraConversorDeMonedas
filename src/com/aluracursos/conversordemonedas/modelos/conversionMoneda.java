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
    private double calculo;


        public conversionMoneda(monedaExchageApi miMonedaExchangeApi) throws IOException, InterruptedException {
            this.rates = miMonedaExchangeApi.rates();
            //this.valorMonedaAConvertir = miMonedaExchangeApi.rates().get("MXN");
            this.monedaBase = miMonedaExchangeApi.baseCode();
        }

        public double calculoConversionMoneda(String moneda, double cantidad , int opcion){
                if (opcion%2 == 1){
                    return this.rates.get(moneda) * cantidad;
                } else  {
                    return cantidad / this.rates.get(moneda);
                }
        }


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
