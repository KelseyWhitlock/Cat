package Cat.Blog.Controller;
import Cat.Blog.model.Cat;
import Cat.Blog.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    //Calling the cat service to this class
    private final CatService catService;

    //This will be the constuctor to make the cat service work
    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    //Showing all the cats in the database
    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    //Find the cat through the id
    @GetMapping( path="/{catId}")
    public Cat getCatId(@PathVariable("catId") int catId) {
        Optional<Cat> cat = catService.getCatId(catId);
        return cat.orElse(null);
    }

    //Adding a cat to the database
    @PostMapping
    public void addCat(@RequestBody Cat cat) {
        catService.addCat(cat.getColor(), cat.getName());
    }

    //Updating the cat through the user and setting it to the database
    @PutMapping(path= "{catId}")
    public String updateCat(@PathVariable int catId, @RequestBody Cat updateCat) {
        try {
            catService.updateCat(catId, updateCat.getColor(), updateCat.getName());
            return "Cat updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    //Deleting a cat from the database
    @DeleteMapping(path= "{catId}")
    public void deleteCat(@PathVariable int catId){
        catService.deleteCat(catId);
    }

}
