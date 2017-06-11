package ch.adesso.partyservice.party.boundary;

import ch.adesso.partyservice.party.entity.Person;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Map;

@Path("parties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class PartyResource {

    @GET
    public Person getAll(){
       return new Person("1","Maria", "Aranda", "Active", LocalDateTime.parse("1981-12-15T00:00:00"));
    }

}
