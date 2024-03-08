package com.buddhapps.globalsanghaback.repository;

import com.buddhapps.globalsanghaback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    // Puedes añadir métodos personalizados de consulta aquí si es necesario
}
