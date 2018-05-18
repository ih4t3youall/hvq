package ar.com.sourcesistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.sourcesistemas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
