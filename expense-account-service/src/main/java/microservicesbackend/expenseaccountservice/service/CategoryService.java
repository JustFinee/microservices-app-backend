package microservicesbackend.expenseaccountservice.service;


import javassist.NotFoundException;
import microservicesbackend.expenseaccountservice.entity.Category;
import microservicesbackend.expenseaccountservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(Long idUser) throws NotFoundException {
        List<Category> categories = categoryRepository.findAllByIdUser(idUser);
        if (categories.isEmpty()) throw new NotFoundException("There is no categories for this user");
        return categories;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long idCategory) throws NotFoundException {
        Optional<Category> category = categoryRepository.findById(idCategory);
        if (category.isEmpty()) throw new NotFoundException("There is no category with this id");

        categoryRepository.deleteById(idCategory);
    }
}
