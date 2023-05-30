package com.example.soapclient.client;

import com.example.soapclient.schema.GetCountryRequest;
import com.example.soapclient.schema.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

@Slf4j
public class SoapClient extends WebServiceGatewaySupport {

    private static final String SOAP_ACTION = "getCountryRequest";  // nome azione
    private static final String SOAP_URI = "http://localhost:8080/ws";  // address location presente nel file .wsdl

    public Object getCountry(String country) {
        GetCountryRequest requestPayload = new GetCountryRequest();
        requestPayload.setName(country);

        try {
            GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
                    SOAP_URI, requestPayload, message -> ((SoapMessage) message).setSoapAction(SOAP_ACTION)
            );
            return response.getCountry();
        } catch (Exception e) {
            log.error("Errore chiamata servizio SOAP: {}", e.getMessage());
            return null;
        }
    }
}
