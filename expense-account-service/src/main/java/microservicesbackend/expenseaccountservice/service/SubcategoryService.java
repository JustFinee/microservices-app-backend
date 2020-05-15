package microservicesbackend.expenseaccountservice.service;

import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Category;
import microservicesbackend.expenseaccountservice.entity.Subcategory;
import microservicesbackend.expenseaccountservice.repository.CategoryRepository;
import microservicesbackend.expenseaccountservice.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubcategoryService {

    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;


    public List<Subcategory> getAllSubcategory(Long idUser) throws NotFoundException
    {
        List<Subcategory> subcategories =subcategoryRepository.findAll().stream()
                .filter(x-> x.getCategory().getIdUser()==idUser)
                .collect(Collectors.toList());

        if (subcategories.isEmpty()) throw new NotFoundException("There is no subcategories for this idUser");
        return subcategories;
    }

    public Subcategory addSubcategory(String name,Long categoryId) throws NotFoundException
    {
        Optional<Category> category = categoryRepository.findById(categoryId);

        if (category.isEmpty()) throw new NotFoundException("There is no category with this id");
        else
        {
            Subcategory subcategory = new Subcategory(name,category.get());
            return subcategoryRepository.save(subcategory);

        }
    }

    public List<Subcategory> getAllSubcategoryForCategory(Long idUser, Long idCategory) throws NotFoundException
    {
        List<Subcategory> subcategories =subcategoryRepository.findAll().stream()
                .filter(x-> x.getCategory().getIdUser()==idUser && x.getCategory().getCategoryId()==idCategory)
                .collect(Collectors.toList());

        if (subcategories.isEmpty()) throw new NotFoundException("There is no subcategories for this idUser");
        return subcategories;
    }

    public Subcategory createSubcategory(Subcategory subcategory)
    {
        return subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(Long idSubcategory) throws NotFoundException
    {
        if (subcategoryRepository.findById(idSubcategory).isEmpty()) throw new NotFoundException("There is no subcategory for this id");
        subcategoryRepository.deleteById(idSubcategory);
    }
}
