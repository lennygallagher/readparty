package ch.adesso.partyservice.party.entity;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.avro.reflect.Nullable;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 23.06.17.
 */
@ToString
public class Header {
    @Nullable
    private Map<String, Object> properties;

    public Header() {
        properties = new HashMap<String, Object>();
    }

    public void addProperty(String name, Object value) {
        properties.put(name, value);
    }

    public void removeProperty(String name) {
        properties.remove(name);
    }
}
