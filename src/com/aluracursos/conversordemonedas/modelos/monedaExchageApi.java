package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record monedaExchageApi(
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Map<String, Double> rates
){

}