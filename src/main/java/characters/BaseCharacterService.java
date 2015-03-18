package characters;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by stephensanchez on 3/17/15.
 */
public class BaseCharacterService implements CharacterService {

    @Override
    public Character getCharacter(String name) {
        Session session = createSession();
        List characters = session.createQuery("from Character as character where character.name = " + name).list();
        return (Character)characters.get(0);
    }

    @Override
    public Character createCharacter(String name) {
        Session session = createSession();
        BaseCharacter character = new BaseCharacter();
        character.setName(name);
        session.save(character);
        session.getTransaction().commit();
        return character;
    }

    @Override
    public Character updateCharacter(Character character) {
        Session session = createSession();
        session.save(character);
        session.getTransaction().commit();
        return character;
    }

    /**
     * Simple helper method for creating a new session and opening a transaction.
     * @return The open session.
     */
    private Session createSession() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(
                new StandardServiceRegistryBuilder().build() );
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }
}
