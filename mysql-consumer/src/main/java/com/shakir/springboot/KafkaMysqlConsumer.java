package com.shakir.springboot;

import com.shakir.springboot.Entity.WikimediaChanges;
import com.shakir.springboot.Repository.WikimediaChangesRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMysqlConsumer {

    private WikimediaChangesRepo wikimediaChangesRepo;

    public KafkaMysqlConsumer(WikimediaChangesRepo wikimediaChangesRepo) {
        this.wikimediaChangesRepo = wikimediaChangesRepo;
    }

    @KafkaListener(topics = "wikimedia_recent",groupId = "myGroup")
    public void consume(String message){
        System.out.println(message);
        System.out.println(message.length());
        WikimediaChanges wikimediaChanges=new WikimediaChanges();
        wikimediaChanges.setWikimediaInfo(message);
        wikimediaChangesRepo.save(wikimediaChanges);


    }
}
