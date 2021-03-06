package ch.adesso.partyservice.party.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by hackathon on 11.06.17.
 */
@Data
@ToString
@NoArgsConstructor
public class PersonCreatedEvent extends PartyEvent {

    private String partyId;
    private String firstname;
    private String lastname;
    public PersonCreatedEvent(String partyId, String firstname, String lastname) {
        super(PersonCreatedEvent.class);
        this.partyId = partyId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

}
