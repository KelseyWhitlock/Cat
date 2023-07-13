package Cat.Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Cat.Blog.model.Cat;
import org.springframework.stereotype.Repository;


//API for the Crud Operations
@Repository
public interface CatRepository extends JpaRepository<Cat,Integer> {

}
