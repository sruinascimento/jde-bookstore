package br.com.rsfot.bookstore.category;

public record NewCategoryResponse(String name) {

    public NewCategoryResponse(Category newCategory) {
        this(newCategory.getName());
    }
}
