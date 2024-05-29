package Services;
        import com.example.commentarys;
        import jakarta.enterprise.context.ApplicationScoped;
        import jakarta.persistence.EntityManager;
        import jakarta.persistence.PersistenceContext;
        import jakarta.transaction.Transactional;
        import java.util.List;

@ApplicationScoped
public class ComentarioServiceImpl implements Icommentaryservice {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(commentarys com) {
        em.persist(com);
    }

    @Override
    public commentarys findById(Long id) {
        return em.find(commentarys.class, id);
    }

    @Override
    public List<commentarys> findAll() {
        return em.createQuery("SELECT c FROM commentarys c", commentarys.class).getResultList();
    }

    @Override
    public List<commentarys> findPaginated(int page, int pageSize) {
        return em.createQuery("SELECT c FROM commentarys c", commentarys.class)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
