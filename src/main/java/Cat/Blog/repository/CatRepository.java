package Cat.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Cat.Blog.model.Cat;
import org.springframework.stereotype.Repository;



@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {

}
