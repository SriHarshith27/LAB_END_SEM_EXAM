package com.klef.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.klef.model.Product;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private final String API_URL = "https://fakestoreapi.com/products"; 
    
    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProducts() {

    	UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("fakestoreapi.com")
                .path("/products");
        
        Product[] products = restTemplate.getForObject(builder.toUriString(), Product[].class);
        return Arrays.asList(products);
    }
}
   