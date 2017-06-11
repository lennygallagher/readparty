package ch.adesso.partyservice.party.entity;

/**
 * Created by hackathon on 11.06.17.
 */
public class PersonCreatedEvent extends CoreEvent {

    public PersonCreatedEvent(String id, String name) {
        super(id, name);
    }
}
