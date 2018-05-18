package ar.com.sourcesistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.sourcesistemas.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);

}
