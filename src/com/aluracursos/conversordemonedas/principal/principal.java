package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.http.Conexionhttp;
import com.aluracursos.conversordemonedas.modelos.conversionMoneda;
import com.aluracursos.conversordemonedas.modelos.monedaExchageApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;


import java.io.IOException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        String tipoMoneda = "";

        Conexionhttp nuevaConexion = new Conexionhttp();
        System.out.println(nuevaConexion.getJson());
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        monedaExchageApi conversionMoneda1 =  gson.fromJson(nuevaConexion.getJson(),monedaExchageApi.class);
        conversionMoneda conversion = new conversionMoneda(conversionMoneda1);

        String menu = """
                *************************************************
                Sea bienvenido/a al Conversor de Moneda OwO
                
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real Brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colimbiano ==> Dólar
                7) Salir
                
                
                Ingrese un opcion valida:
                **************************************************
                """;

        //int opcion = 1;

        while (true) {
            System.out.println(menu);
            int opcion = teclado.nextInt();
            if (opcion ==  7) {
                System.out.println("Gracias por utilizar el Conversor de Monedas");
                break;
            } else if (opcion == 1 || opcion == 2) {
                tipoMoneda = "ARS";
            } else if (opcion == 3 || opcion == 4) {
                tipoMoneda = "BRL";
            } else if (opcion == 5 || opcion == 6) {
                tipoMoneda = "COP";
            } else {
                System.out.println("Esta no es una opcion valida");
                break;
            }
            System.out.println("Ingrese el valor que desea convertir");
            double cantidad = teclado.nextDouble();
            //System.out.println(conversion.calculoConversionMoneda(tipoMoneda,cantidad, opcion));

            if (opcion%2 == 1) {
                System.out.println("El valor de " + cantidad + " [USD] corresponde al valor final de =>>> "
                        + conversion.calculoConversionMoneda(tipoMoneda,cantidad, opcion) + " [" + tipoMoneda + "]");
            } else {
                System.out.println("El valor de " + cantidad + " [" + tipoMoneda + "]" + " corresponde al valor final de =>>> "
                        + conversion.calculoConversionMoneda(tipoMoneda,cantidad, opcion) + " [USD]");
            }

        }


    }
}