package com.vw.customer.tracking.demo.controller.rest;

import com.vw.customer.tracking.demo.dto.CartypeDTO;
import com.vw.customer.tracking.demo.service.ICartypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartype")
public class CartypeRestController {
  @Autowired
  ICartypeService cartypeService;

  @GetMapping("")
  public List<CartypeDTO> getAll() {
    return cartypeService.getAll();
  }

  @GetMapping("/{id}")
  public CartypeDTO getCartype(@PathVariable("id") Long id) {
    return cartypeService.get(id);
  }

  @PostMapping("/new")
  public CartypeDTO newCartype(@RequestBody CartypeDTO cartypeDTO) {
    return cartypeService.save(cartypeDTO);
  }

  @PutMapping("/update")
  public CartypeDTO updateCartype(@RequestBody CartypeDTO cartypeDTO) {
    return cartypeService.save(cartypeDTO);
  }

  @DeleteMapping("/{id}")
  public void deleteCartype(@PathVariable("id") Long id) {
    cartypeService.delete(id);
  }

  @DeleteMapping("/{id}/procedure")
  public void deleteCartypeProcedure(@PathVariable("id") Long id) {
    cartypeService.deleteProcedure(id);
  }

}
