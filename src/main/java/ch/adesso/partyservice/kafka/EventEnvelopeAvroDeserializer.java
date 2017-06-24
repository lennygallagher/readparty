package ch.adesso.partyservice.kafka;

import ch.adesso.partyservice.party.entity.EventEnvelope;

/**
 * Created by tom on 23.06.17.
 */
public class EventEnvelopeAvroDeserializer extends KafkaAvroReflectDeserializer<EventEnvelope> {
    public EventEnvelopeAvroDeserializer() {
        super(EventEnvelope.class);
    }
}