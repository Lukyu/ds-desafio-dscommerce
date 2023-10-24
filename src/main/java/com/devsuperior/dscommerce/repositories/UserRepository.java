package com.devsuperior.dscommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projections.UserDetailsProjection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	@Query(nativeQuery = true,
			value = "SELECT "
			+ "tb_user.name as username, tb_user.password, tb_role.id as roleId, tb_role.authority "
			+ "FROM tb_user "
			+ "INNER JOIN tb_user_role "
			+ "ON tb_user.id = tb_user_role.user_id "
			+ "INNER JOIN tb_role "
			+ "ON tb_user_role.role_id = tb_role.id "
			+ "WHERE tb_user.email = :email")
	List<UserDetailsProjection> searchUserAnRolesByEmail(String email);
	
}
