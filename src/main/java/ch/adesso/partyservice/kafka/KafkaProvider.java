package ch.adesso.partyservice.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;


@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class KafkaProvider {

    public static final String TOPIC = "person";
    public static final String KAFKA_ADDRESS = "kafka-1:29092,kafka-2:39092,kafka-3:49092";
    public static final String GROUP_ID = "party-gr";

    //public static final String GROUP_ID = "toDefine";

    private KafkaConsumer<String, String> consumer;

    @PostConstruct
    public void init() {
        this.consumer = createConsumer();
    }

    @Produces
    public KafkaConsumer<String, String> getConsumer() {
        return consumer;
    }

    public KafkaConsumer<String, String> createConsumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_ADDRESS);
        properties.put("group.id", GROUP_ID + UUID.randomUUID().toString());
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(TOPIC));
        return consumer;
    }
}
