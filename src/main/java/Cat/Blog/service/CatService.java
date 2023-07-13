package Cat.Blog.service;
import Cat.Blog.model.Cat;
import Cat.Blog.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getAllCats(){
       return catRepository.findAll();
    }

    public Optional<Cat> getCatId( int catId){
        return catRepository.findById(catId);
    }

    public Cat addCat( String color, String name){
        Cat cat = new Cat();
        cat.setColor(color);
        cat.setName(name);
        return catRepository.save(cat);
    }

    public Cat updateCat(int catId, String color, String name) throws Exception {
        Optional<Cat> optionalCat = catRepository.findById(catId);
        if (optionalCat.isPresent()) {
            Cat cat = optionalCat.get();
            cat.setColor(color);
            cat.setName(name);
            return catRepository.save(cat);
        } else {
            throw new Exception("Cat not found");
        }
    }

    public void deleteCat(int catId){
        catRepository.deleteById(catId);
    }
}
