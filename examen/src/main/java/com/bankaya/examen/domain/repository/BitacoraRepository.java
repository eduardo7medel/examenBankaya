package com.bankaya.examen.domain.repository;

import com.bankaya.examen.domain.entity.Bitacora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BitacoraRepository extends CrudRepository<Bitacora, Integer> {
}
