package ch.adesso.partyservice.party.boundary;

import ch.adesso.partyservice.InMemoryStore;
import ch.adesso.partyservice.party.entity.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Path("parties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class PartyResource {

    @Inject
    InMemoryStore inMemoryStore;

    @GET
    public Collection<Person> getAll(){
       return inMemoryStore.personMap.values();
    }

}
