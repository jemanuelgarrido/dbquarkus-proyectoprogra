package repositorys;
import com.example.users;
import implementation.Iusers;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserRepository implements Iusers {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public void save(users user) {em.persist(user);}

    @Override
    public void save(Iusers user) {

    }
}
