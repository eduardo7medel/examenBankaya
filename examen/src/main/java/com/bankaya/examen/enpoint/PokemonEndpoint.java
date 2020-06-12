package com.bankaya.examen.enpoint;

import com.bankaya.examen.domain.entity.Bitacora;
import com.bankaya.examen.domain.repository.BitacoraRepository;
import com.bankaya.examen.dto.GetPokemonRequest;
import com.bankaya.examen.dto.GetPokemonResponse;
import com.bankaya.examen.dto.PingResponse;
import com.bankaya.examen.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Autowired
    private HttpServletRequest httpRequest;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {
        try {
            bitacoraRepository.save(new Bitacora(request.getName(), getIpAddress(), "getPokemon", new Date()));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return pokemonRepository.getPokemon(request.getName());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Ping")
    public @ResponsePayload
    PingResponse ping() {
        PingResponse resposta = new PingResponse();
        resposta.setOut("I'm in");
        return resposta;
    }

    private String getIpAddress() {
        String ipAddress = httpRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpRequest.getRemoteAddr();
        }
        return ipAddress;
    }

}
