package ch.adesso.partyservice;

import ch.adesso.partyservice.party.entity.Person;
import lombok.Setter;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class InMemoryStore {

    @Setter
    public Map<String, Person> personMap = new HashMap<>();

}
