package Services;

import com.example.commentarys;

import java.util.List;

public interface Icommentaryservice {
    public void save(commentarys com);

    commentarys findById(Long id);

    List<commentarys> findAll();

    List<commentarys> findPaginated(int page, int pageSize);
}



