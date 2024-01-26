package out.persistence;

import java.util.List;
import java.util.Optional;

public interface Repository<E> {
    Optional<E> create(E entity);
    Optional<List<E>> findAll();
}
