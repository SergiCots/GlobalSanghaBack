package com.buddhapps.globalsanghaback.repository;

import com.buddhapps.globalsanghaback.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    // Aquí puedes añadir métodos de consulta personalizados si es necesario
    List<Tool> findByOwner_Id(Long ownerId);
}
