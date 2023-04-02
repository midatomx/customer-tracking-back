package com.vw.customer.tracking.demo.service;

import com.vw.customer.tracking.demo.dto.ProspectDTO;
import com.vw.customer.tracking.demo.model.Cartype;
import com.vw.customer.tracking.demo.model.Prospect;
import com.vw.customer.tracking.demo.repository.ICartypeJpaRepository;
import com.vw.customer.tracking.demo.repository.IProspectJpaRepository;
import com.vw.customer.tracking.demo.service.exception.ProspectNotFoundException;
import com.vw.customer.tracking.demo.service.exception.TechnicalException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class ProspectServiceImpl implements IProspectService {

  @Autowired
  private IProspectJpaRepository prospectRepository;

  @Autowired
  private ICartypeJpaRepository cartypeRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<ProspectDTO> getAll() {
    List<Prospect> listProspectEntity = prospectRepository.findAll();
    List<ProspectDTO> listProspectDto = listProspectEntity.stream()
      .map(prospect -> modelMapper.map(prospect, ProspectDTO.class))
      .collect(Collectors.toList());
    return listProspectDto;
  }

  @Override
  public ProspectDTO get(Long id) throws ProspectNotFoundException, TechnicalException {
    ProspectDTO prospectDTO;
    try {
      Prospect prospectEntity = prospectRepository.findById(id).get();
      prospectEntity.getName();
      prospectDTO = modelMapper.map(prospectEntity, ProspectDTO.class);
    } catch (ProspectNotFoundException e) {
      throw new ProspectNotFoundException(id, e);
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
    return prospectDTO;
  }

  @Override
  public ProspectDTO save(ProspectDTO prospectDTO) {
    System.out.println("save: prospectDTO: " + prospectDTO);
    Prospect prospectEntity = modelMapper.map(prospectDTO, Prospect.class);

    if (prospectDTO.getId() != null) {
      prospectEntity.setId(prospectDTO.getId());
    }
    Cartype cartypeEntity = cartypeRepository.findById(prospectDTO.getCartype().getId()).get();
    prospectEntity.setCartype(cartypeEntity);
    prospectEntity = prospectRepository.save(prospectEntity);
    return modelMapper.map(prospectEntity, ProspectDTO.class);
  }

  @Override
  public void delete(Long id) throws ProspectNotFoundException, TechnicalException {
    try {
      prospectRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ProspectNotFoundException(id, e);
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
  }

  @Override
  public void deleteProcedure(Long id) {
    try {
      prospectRepository.deleteByProcedure(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ProspectNotFoundException(id, e);
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
  }

  @Override
  public int countAllFunction() {
    try {
      return prospectRepository.countAll();
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
  }

  @Override
  public List<ProspectDTO> getAllProcedure() {
    List<ProspectDTO> prospectDTOList = new ArrayList<ProspectDTO>();
    try {
      List<Prospect> prospects = (List<Prospect>) prospectRepository.findAll();
      for (Prospect prospect : prospects) {
        prospectDTOList.add(modelMapper.map(prospect, ProspectDTO.class));
      }
      return prospectDTOList;
    } catch (Exception e) {
      throw new TechnicalException(e);
    }
  }

}
