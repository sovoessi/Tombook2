package com.dahomeykid.byblos;

import com.dahomeykid.byblos.entity.Book;

import com.dahomeykid.byblos.gbooks.GBooks;
import com.dahomeykid.byblos.gbooks.items.ItemsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import org.springframework.web.client.RestTemplate;


import java.io.File;
import java.util.List;


@SpringBootApplication
public class Tombook2Application {

    public static void main(String[] args) {
        SpringApplication.run(Tombook2Application.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(Tombook2Application.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    CommandLineRunner runner(ItemsService itemsService) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();

            final GBooks[] gBooks = new GBooks[1];

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<Book>> typeReference = new TypeReference<>() {};

            File jsonFile = new ClassPathResource("data/books.json").getFile();
            List<Book>books = objectMapper.readValue(jsonFile, typeReference);

                books.forEach(book -> {
                    gBooks[0] = restTemplate.getForObject(
                            "https://www.googleapis.com/books/v1/volumes?q=" + book.getTitle(), GBooks.class);

                    try{
                        assert gBooks[0].getItems()[0] != null;
                        log.info(gBooks[0].getItems()[0].toString());
                        itemsService.saveItems(gBooks[0].getItems()[0]);
                    }catch (NullPointerException ex){
                        System.out.println(ex.getMessage());
                    }
                });
        };
    }

}
