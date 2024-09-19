
package com.Colegio.colegio.repository;

import com.Colegio.colegio.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripcionRepository extends JpaRepository<Inscripcion, Long> {
    
}
