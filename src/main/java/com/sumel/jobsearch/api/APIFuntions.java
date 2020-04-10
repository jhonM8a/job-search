package com.sumel.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;
/**
 * Para poder cambiar facilemte de librearia.
 * Lo que se realiza es construir el cliente web
 * decodificar los resultados en GSON y
 * apuntando a un API que esta en una URL
 * */
public interface APIFuntions {
    static <T> T buildAPI(Class<T> clazz, String url){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }
}
