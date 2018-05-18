package ar.com.sourcesistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.sourcesistemas.model.Category;
import ar.com.sourcesistemas.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(String id) {
		return categoryRepository.findById(id);
	}
}
