package ch.adesso.partyservice.party.entity;

/**
 * Created by hackathon on 11.06.17.
 */
public class PersonCreatedEvent extends CoreEvent {

    public static String NAME = "ch.adesso.partyservice.party.personcreated";

    public PersonCreatedEvent(CoreEvent coreEvent) {
        super(coreEvent.getId(), coreEvent.getName());
    }
}
