package org.sample;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import io.smallrye.reactive.messaging.kafka.MessageHeaders;
import kafka.utils.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@ApplicationScoped
public class Consumer {


    @Incoming("kafka")
    public CompletionStage<?> consume(KafkaMessage<String, String> message) {
        String payload = message.getPayload();
        String key = message.getKey();
        MessageHeaders headers = message.getHeaders();
        Integer partition = message.getPartition();
        Long timestamp = message.getTimestamp();
        System.out.println("ok");

        return CompletableFuture.supplyAsync(() -> 10);
    }

}
