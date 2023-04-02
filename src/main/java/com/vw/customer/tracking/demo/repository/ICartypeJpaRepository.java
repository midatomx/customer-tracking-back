package com.vw.customer.tracking.demo.repository;

import com.vw.customer.tracking.demo.model.Cartype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICartypeJpaRepository extends JpaRepository<Cartype, Long> {

  Cartype findByCode(String code);

  @Transactional
  @Modifying
  @Query(value = "call remove_cartype(:cartypeId)", nativeQuery = true)
  void deleteByProcedure(@Param("cartypeId") Long cartypeId);

}
