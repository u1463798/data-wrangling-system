package com.wrangling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Configuration
public class JacksonConfiguration {

//    @Bean
//    public ObjectMapper objectMapper() {
//    	System.out.println("Initialized mapper bean");
//        return new ObjectMapper()
//                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT )
//                .enable(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY );
//    }
}
