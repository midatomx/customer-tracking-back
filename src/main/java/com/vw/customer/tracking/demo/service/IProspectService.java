package com.vw.customer.tracking.demo.service;

import com.vw.customer.tracking.demo.dto.ProspectDTO;

import javax.validation.Valid;
import java.util.List;

public interface IProspectService {

  public ProspectDTO save(@Valid ProspectDTO prospect);

  public ProspectDTO get(Long id);

  public List<ProspectDTO> getAll();

  public void delete(Long id);

  public void deleteProcedure(Long id);

  public int countAllFunction();

  public List<ProspectDTO> getAllProcedure();


}
