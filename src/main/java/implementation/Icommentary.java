package implementation;

import com.example.commentarys;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.transaction.Transactional;

import java.util.List;

public interface Icommentary  extends PanacheRepository<commentarys> {
        public void saveComment(commentarys com);
        public commentarys getComentario();
        List<commentarys> getComentarios();
    }
