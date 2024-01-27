package out.persistence;

import java.util.List;
import java.util.Optional;

public interface Repository<E> {
    E create(E entity);
    List<E> findAll();
}
