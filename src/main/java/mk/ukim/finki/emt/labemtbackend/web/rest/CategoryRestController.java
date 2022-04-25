package mk.ukim.finki.emt.labemtbackend.web.rest;

import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://lab2emt-frontend.herokuapp.com/")
@RequestMapping("/categories")
public class CategoryRestController {

    @GetMapping
    public List<String> findAll() {
        List<String> list = new ArrayList<>();
        for(Category c: Category.values())
            list.add(c.toString());
        return list;
    }
}
