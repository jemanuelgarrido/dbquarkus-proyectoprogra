package repositorys;


import implementation.Icommentary;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import com.example.commentarys;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.*;

@ApplicationScoped
public class ComentarioRepository implements Icommentary {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    //hacer que se guarde en formato txt el comentario
    public void saveComment(commentarys com) {
        persist(com);
    }



    public commentarys getComentario(){
        return find("id", 1).firstResult();
    }

    @Override
    public List<commentarys> getComentarios() {
        return listAll();
    }


}
