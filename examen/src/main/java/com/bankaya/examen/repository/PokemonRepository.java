package com.bankaya.examen.repository;

import com.bankaya.examen.dto.Ability;
import com.bankaya.examen.dto.GetPokemonAbilitiesResponse;
import com.bankaya.examen.dto.GetPokemonResponse;
import com.bankaya.examen.dto.HeldItemsResponse;
import com.bankaya.examen.dto.Item;
import com.bankaya.examen.dto.Version;
import com.bankaya.examen.dto.VersionDetails;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.springframework.stereotype.Component;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

@Component
public class PokemonRepository {
    private static String API_POKEMON_URL = "https://pokeapi.co/api/v2/pokemon/{pokemon}/";

    public GetPokemonResponse getPokemon(String pokemonName) {

        GetPokemonResponse result = new GetPokemonResponse();
        JsonNode resultConsult = consultPokemonByName(pokemonName);
        result.setBaseExperience(resultConsult.get("base_experience").asInt());
        result.setAbilities(getPokemonAbilities(resultConsult.get("abilities").iterator()));
        result.setId(resultConsult.get("id").asInt());
        result.setName(resultConsult.get("name").asText());
        result.setLocationAreaEncounters(resultConsult.get("location_area_encounters").asText());
        result.setHeldItems(getPokemonHeldItems(resultConsult.get("held_items").iterator()));

        return result;
    }

    private ArrayList<GetPokemonAbilitiesResponse> getPokemonAbilities( Iterator<JsonNode> iterator ) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ArrayList<GetPokemonAbilitiesResponse> responses = new ArrayList<GetPokemonAbilitiesResponse>();
            GetPokemonAbilitiesResponse nodo = new GetPokemonAbilitiesResponse();
            JsonNode abilityJson = null;
            while (iterator.hasNext()){
                abilityJson = iterator.next();
                nodo.setHidden(abilityJson.get("is_hidden").asBoolean());
                nodo.setSlot(abilityJson.get("slot").asInt());
                Ability ability = new Ability();
                ability.setName(abilityJson.get("ability").get("name").asText());
                ability.setUrl(abilityJson.get("ability").get("url").asText());
                nodo.setAbility(ability);
                responses.add(nodo);
            }

            return responses;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return new ArrayList<GetPokemonAbilitiesResponse>();
    }

    private ArrayList<HeldItemsResponse> getPokemonHeldItems(Iterator<JsonNode> iterator ) {

        try {
            ArrayList<HeldItemsResponse> responses = new ArrayList<HeldItemsResponse>();
            HeldItemsResponse nodo = new HeldItemsResponse();
            JsonNode heldItemJson = null;
            while (iterator.hasNext()){
                heldItemJson = iterator.next();
                nodo.setItem( new Item(heldItemJson.get("item").get("name").asText(), heldItemJson.get("item").get("url").asText()) );
                nodo.setVersionDetails(getVersionDetails(heldItemJson.get("version_details").elements()));

                responses.add(nodo);
            }

            return responses;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return new ArrayList<HeldItemsResponse>();
    }

    private ArrayList<VersionDetails> getVersionDetails(Iterator<JsonNode> iterator){

        try {
            ArrayList<VersionDetails> responses = new ArrayList<VersionDetails>();
            VersionDetails nodo = new VersionDetails();
            JsonNode versiondetail = null;
            while (iterator.hasNext()){
                versiondetail = iterator.next();
                nodo.setRarity( versiondetail.get("rarity").asInt() );
                nodo.setVersion(new Version(versiondetail.get("version").get("name").asText(), versiondetail.get("version").get("url").asText()));

                responses.add(nodo);
            }

            return responses;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return new ArrayList<VersionDetails>();

    }

    private JsonNode consultPokemonByName( String pokemonName){
        ObjectMapper objectMapper = new ObjectMapper();
        SSLContextBuilder SSLBuilder = SSLContexts.custom();
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLBuilder.build();

            SSLConnectionSocketFactory sslConSocFactory = new SSLConnectionSocketFactory(sslcontext, new NoopHostnameVerifier());
            HttpClientBuilder clientbuilder = HttpClients.custom();
            clientbuilder = clientbuilder.setSSLSocketFactory(sslConSocFactory);
            CloseableHttpClient httpclient = clientbuilder.build();
            HttpGet httpget = new HttpGet(API_POKEMON_URL.replace("{pokemon}", pokemonName));
            HttpResponse httpresponse = httpclient.execute(httpget);
            String resultadoConsulta = convertStreamToString(httpresponse.getEntity().getContent());

            return objectMapper.readTree(resultadoConsulta);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
