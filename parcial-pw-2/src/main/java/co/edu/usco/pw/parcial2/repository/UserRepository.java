package co.edu.usco.pw.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usco.pw.parcial2.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}