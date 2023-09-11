package repository;

import entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,Integer> {
    List<BookEntity> finByAuthor(String author);
}
