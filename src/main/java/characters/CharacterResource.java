package characters;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("characters")
public class CharacterResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String characters() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CharacterResource");
        return "TODO: some JSON serialization of a character";
    }

}