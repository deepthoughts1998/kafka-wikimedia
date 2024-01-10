package com.shakir.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WikimediaProducer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WikimediaProducer.class);
    }

    @Autowired
    private KafkaWikimediaProducer kafkaWikimediaProducer;

    @Override
    public void run(String... args) throws Exception {
        kafkaWikimediaProducer.sendMessage();
    }
}
