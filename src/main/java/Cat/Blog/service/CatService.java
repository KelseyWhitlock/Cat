package Cat.Blog.service;
import Cat.Blog.model.Cat;
import Cat.Blog.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    //Calling the cat repository
    private final CatRepository catRepository;

    //The constructor so that is making the cat repository working
    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    //Will get all the list of the cats in the database
    public List<Cat> getAllCats(){
       return catRepository.findAll();
    }

    //Will find the cat through the database through the ide
    public Optional<Cat> getCatId( int catId){
        return catRepository.findById(catId);
    }

    //This will add cat to the database
    public Cat addCat( String color, String name){
        Cat cat = new Cat();
        cat.setColor(color);
        cat.setName(name);
        return catRepository.save(cat);
    }

    //This will update the cat from the database, this will be only changing the name and the color
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

    //This will deleted the cat from the database
    public void deleteCat(int catId){
        catRepository.deleteById(catId);
    }
}
