package com.example.soapclient.service;

import com.example.soapclient.client.SoapClient;
import com.example.soapclient.schema.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final SoapClient soapClient;

    public Country getCountry(String country) {
        return (Country) soapClient.getCountry(country);
    }
}
