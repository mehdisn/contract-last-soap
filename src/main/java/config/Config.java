package config;

import service.DataLayerServiceImpl;

import javax.xml.ws.Endpoint;

public class Config {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/dataservice", new DataLayerServiceImpl());
    }
}
