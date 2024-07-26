package br.com.rsfot.bookstore.category;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/category")
    @Transactional
    public ResponseEntity create(@Valid @RequestBody NewCategoryRequest newCategoryRequest) {
        Category newCategory = newCategoryRequest.toEntity();

        categoryRepository.save(newCategory);

        return ResponseEntity.ok(new NewCategoryResponse(newCategory));
    }
}
