package ch.adesso.partyservice.party.entity;

import ch.adesso.partyservice.LocalDateTimeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.json.Json;
import javax.json.JsonObject;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
public class Person {

    private String id;
    private String firstname;
    private String lastname;
    private String status;
    private long version;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime birthdate;

    public Person(String id){
        this.id = id;
    }
}
