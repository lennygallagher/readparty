package ch.adesso.partyservice;

import ch.adesso.partyservice.party.entity.Person;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class InMemoryStore {

    @Getter
    private static Map<String, Person> personMap = new ConcurrentHashMap<>();

}
