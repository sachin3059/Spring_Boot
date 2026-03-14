package com.example.StoreScout.config;


import com.example.StoreScout.client.FakeStoreHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpClientConfig {

    @Bean
    public FakeStoreHttpClient fakeStoreHttpClient(){
        RestClient restClient = RestClient.builder()
                .baseUrl("https://fakestoreapi.com")
                .build();

        HttpServiceProxyFactory  factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();

        return factory.createClient(FakeStoreHttpClient.class);
    }
}
