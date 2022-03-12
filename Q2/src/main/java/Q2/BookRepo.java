package Q2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Q2.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer>{

}
