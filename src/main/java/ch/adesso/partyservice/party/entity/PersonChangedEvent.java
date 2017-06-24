package ch.adesso.partyservice.party.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by tom on 23.06.17.
 */
@Data
@ToString
@NoArgsConstructor
public class PersonChangedEvent extends PartyEvent  {

    private String partyId;
    private String firstname;
    private String lastname;
    public PersonChangedEvent(String partyId, String firstname, String lastname) {
        super(PersonCreatedEvent.class);
        this.partyId = partyId;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
