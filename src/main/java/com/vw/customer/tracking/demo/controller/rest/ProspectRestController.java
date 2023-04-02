package com.vw.customer.tracking.demo.controller.rest;

import com.vw.customer.tracking.demo.dto.ProspectDTO;
import com.vw.customer.tracking.demo.service.IProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prospect")
public class ProspectRestController {
  @Autowired
  IProspectService prospectService;

  @GetMapping("")
  public List<ProspectDTO> getAll() {
    return prospectService.getAll();
  }

  @GetMapping("/{id}")
  public ProspectDTO getProspect(@PathVariable("id") Long id) {
    return prospectService.get(id);
  }

  @PostMapping("/new")
  public ProspectDTO newProspect(@RequestBody ProspectDTO prospectDTO) {
    return prospectService.save(prospectDTO);
  }

  @PutMapping("/update")
  public ProspectDTO updateProspect(@RequestBody ProspectDTO prospectDTO) {
    return prospectService.save(prospectDTO);
  }

  @DeleteMapping("/{id}")
  public void deleteProspect(@PathVariable("id") Long id) {
    prospectService.delete(id);
  }

  @DeleteMapping("/{id}/procedure")
  public void deleteProspectProcedure(@PathVariable("id") Long id) {
    prospectService.deleteProcedure(id);
  }

  @GetMapping("/count")
  public int countAllFunction() {
    return prospectService.countAllFunction();
  }

  @GetMapping("/all")
  public List<ProspectDTO> getAllProcedure() {
    return prospectService.getAllProcedure();
  }

}
