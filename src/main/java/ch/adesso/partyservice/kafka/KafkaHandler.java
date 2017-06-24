package ch.adesso.partyservice.kafka;

import ch.adesso.partyservice.party.entity.CoreEvent;
import ch.adesso.partyservice.party.entity.EventEnvelope;
import com.airhacks.porcupine.execution.boundary.Dedicated;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.CompletableFuture.runAsync;

/**
 * Created by aranda on 10.06.2017.
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class KafkaHandler {
    public static final String UNTIL_DATE = "UNTIL_DATE";
    public static final String DATE_FORMAT = "YYYYMMDDhhmm";

    @Inject
    KafkaConsumer<String, EventEnvelope> consumer;

    @Dedicated
    @Inject
    ExecutorService kafka;

    @Inject
    Event<CoreEvent> eventChannel;

    @PostConstruct
    public void onInit() {
       runAsync(this::handleKafkaEvent, kafka);
    }


    public void handleKafkaEvent() {
        while (true) {
            ConsumerRecords<String, EventEnvelope> records = consumer.poll(500);
            for (ConsumerRecord<String, EventEnvelope> record : records) {
                System.out.println("Record value: " + record.value());
                switch (record.topic()) {
                    case KafkaProvider.TOPIC:
                        handleEvents(record);
                        break;
                    default:
                        handleEvents(record);
                        break;
                }
            }
        }
    }

    private void handleEvents(ConsumerRecord<String, EventEnvelope> record) {
        try {
            EventEnvelope envelope =  record.value();
            CoreEvent event = envelope.getEvent();
            event.setVersion(record.offset());
            System.out.println("eventText = " + event.toString());
            eventChannel.fire(event);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
