package microservicesbackend.expenseaccountservice.controller;

import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Subcategory;
import microservicesbackend.expenseaccountservice.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SubcategoryController {


    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/getAllSubcategory/{idUser}")
    public ResponseEntity<List<Subcategory>> getAllSubcategories(@PathVariable("idUser") Long idUser)
    {
        try{
            return new ResponseEntity<>(subcategoryService.getAllSubcategory(idUser), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found subcategories for this idUser", e);
        }
    }

    @GetMapping("/getAllSubcategoryForCategory/{idUser}/{idCategory}")
    public ResponseEntity<List<Subcategory>> getAllSubcategoriesForCategory(@PathVariable("idUser") Long idUser,
                                                                            @PathVariable("idCategory") Long idCategory)
    {
        try{
            return new ResponseEntity<>(subcategoryService.getAllSubcategoryForCategory(idUser,idCategory), HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found subcategories for this idUser and idCategory", e);
        }
    }

    @PostMapping("/createSubcategory")
    public ResponseEntity<Subcategory> createSubcategory(@RequestBody Subcategory subcategory)
    {
        Subcategory createdSubcategory = subcategoryService.createSubcategory(subcategory);
        if (createdSubcategory!=null)
        {
            return new ResponseEntity<>(createdSubcategory,HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteSubcategory/{idSubcategory}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable("idSubcategory") Long idSubcategory)
    {
        try{
            subcategoryService.deleteSubcategory(idSubcategory);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NotFoundException e)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found subcategory with this idSubcategory", e);
        }
    }
}
