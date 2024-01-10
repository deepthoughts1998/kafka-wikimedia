package com.shakir.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaWikimediaProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaWikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws  InterruptedException {
        String topic="wikimedia_recent";

        EventHandler eventHandler=new KafkaWikimediaChanges(kafkaTemplate,topic);
        String url="https://stream.wikimedia.org/v2/stream/test";
        EventSource.Builder builder=new EventSource.Builder(
                eventHandler,
                URI.create(url));
        EventSource eventSource= builder.build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(5);
    }
}
