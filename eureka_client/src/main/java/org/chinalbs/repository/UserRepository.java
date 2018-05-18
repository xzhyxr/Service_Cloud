package org.chinalbs.repository;

import org.chinalbs.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="user")
public interface UserRepository extends JpaRepository<User, Long>{  
}
