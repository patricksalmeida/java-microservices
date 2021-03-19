package br.com.patrickalmeida.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.patrickalmeida.hruser.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
