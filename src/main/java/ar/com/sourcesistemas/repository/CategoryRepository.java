package ar.com.sourcesistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.sourcesistemas.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findById(String id);
}
