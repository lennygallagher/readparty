package ch.adesso.partyservice.party.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.avro.reflect.AvroDefault;
import org.apache.avro.reflect.AvroIgnore;
import org.apache.avro.reflect.Nullable;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by tom on 11.06.17.
 */
@Data
@NoArgsConstructor
@ToString
public class CoreEvent {
    private String eventId;
    private String eventType;
    private long timestamp;

    @AvroIgnore
    private long version;

    public CoreEvent(Class<?> eventType) {
        this.eventId = UUID.randomUUID().toString();
        this.timestamp = System.nanoTime();
        this.eventType = eventType.getName();
    }
}
