package microservicesbackend.expenseaccountservice.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Category;
import microservicesbackend.expenseaccountservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllUserCategory/{idUser}")
    public ResponseEntity<List<Category>> getAllCategories(@PathVariable("idUser") Long idUser) {
        try {
            return new ResponseEntity<>(categoryService.getAllCategories(idUser), HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found categories for this user id");
        }

    }

    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);

        if (createdCategory != null) {
            return new ResponseEntity<>(createdCategory, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/deleteCategory/{idCategory}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("idCategory") Long idCategory) {
        try {
            categoryService.deleteCategory(idCategory);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found category with this id");
        }
    }
}




