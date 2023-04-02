package com.vw.customer.tracking.demo.service;

import com.vw.customer.tracking.demo.dto.CartypeDTO;

import javax.validation.Valid;
import java.util.List;

public interface ICartypeService {

  public CartypeDTO save(@Valid CartypeDTO cartype);

  public CartypeDTO get(Long id);

  public List<CartypeDTO> getAll();

  public void delete(Long id);

  public void deleteProcedure(Long id);

}
