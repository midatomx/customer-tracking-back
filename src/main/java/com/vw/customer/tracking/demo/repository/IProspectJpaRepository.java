package com.vw.customer.tracking.demo.repository;

import com.vw.customer.tracking.demo.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProspectJpaRepository extends JpaRepository<Prospect, Long> {

  Prospect findByEmail(String email);

  @Query(value = "SELECT registered_customers()", nativeQuery = true)
  int countAll();

  @Procedure(value = "prospect_list")
  List<Prospect> findAll();

  @Transactional
  @Modifying
  @Query(value = "call remove_prospect(:prospectId)", nativeQuery = true)
  void deleteByProcedure(@Param("prospectId") Long prospectId);

}
