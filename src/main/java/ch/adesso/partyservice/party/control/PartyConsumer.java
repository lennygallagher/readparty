package ch.adesso.partyservice.party.control;

import ch.adesso.partyservice.InMemoryStore;
import ch.adesso.partyservice.party.entity.CoreEvent;
import ch.adesso.partyservice.party.entity.Person;
import ch.adesso.partyservice.party.entity.PersonCreatedEvent;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class PartyConsumer {

    @Inject
    private InMemoryStore inMemoryStore;

    public void handlePersonCreated(@Observes PersonCreatedEvent event){
        System.out.println("inMemoryStore = " + InMemoryStore.getPersonMap());
        System.out.println("Event(handlePersonCreated): " + event.toString());
        Person person = new Person(event.getPartyId());
        person.setFirstname(event.getFirstname());
        person.setLastname(event.getLastname());
        person.setVersion(event.getVersion());
        InMemoryStore.getPersonMap().put(event.getPartyId(), person);
        System.out.println("inMemoryStore = " + inMemoryStore.getPersonMap().size());
    }
}

