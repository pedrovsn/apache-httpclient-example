package com.example.httpclientdemo.service.impl;

import com.example.httpclientdemo.domain.Address;
import com.example.httpclientdemo.service.SearchAddress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchAddressImpl implements SearchAddress {

    private final HttpClient httpClient;

    private final ObjectMapper mapper;

    public SearchAddressImpl(HttpClient httpClient, ObjectMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    @Override
    public Address getAddress(String postalCode) {
        HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/" + postalCode + "/json");
        try {
            HttpResponse httpResponse = this.httpClient.execute(httpGet);
            HttpEntity responseEntity = httpResponse.getEntity();
//            BufferedReader rd = new BufferedReader
//                    (new InputStreamReader(
//                            responseEntity.getContent()));
//
//            String line;
//            while ((line = rd.readLine()) != null) {
//                jsonResponse.append(line);
//            }
//
            Address address = this.mapper.readValue(responseEntity.getContent(), Address.class);

            return address;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
