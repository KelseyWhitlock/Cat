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
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping( path="/cat/{catId}")
    public Cat getCatId(@PathVariable("catId") int catId) {
        Optional<Cat> cat = catService.getCatId(catId);
        return cat.orElse(null);
    }

    @PostMapping
    public void addCat(@RequestBody Cat cat) {
        catService.addCat(cat.getColor(), cat.getName());
    }

    @PutMapping(path= "/cat/{catId}")
    public String updateCat(@PathVariable int catId, @RequestBody Cat updateCat) {
        try {
            catService.updateCat(catId, updateCat.getColor(), updateCat.getName());
            return "Cat updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping(path= "/cat/{catId}")
    public void deleteCat(@PathVariable int catId){
        catService.deleteCat(catId);
    }

}
