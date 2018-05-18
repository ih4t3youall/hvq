package ar.com.sourcesistemas.service;

import java.util.List;

import ar.com.sourcesistemas.model.Category;

public interface CategoryService {
	public List<Category> getAllCategories();

	public Category findCategoryById(String id);
}
