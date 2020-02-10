package com.miage.altea.game_ui.pokemonTypes.service;

import com.miage.altea.game_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate restTemplate;
    String pokemonServiceUrl;

    public List<PokemonType> listPokemonsTypes() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAcceptLanguageAsLocales(Arrays.asList(LocaleContextHolder.getLocale()));
        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<PokemonType[]> types = restTemplate.exchange(pokemonServiceUrl + "/pokemon-types/", HttpMethod.GET, requestEntity, PokemonType[].class);
        return types.getBody() != null ? Arrays.asList(types.getBody()) : new ArrayList<>();
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}