package com.vw.customer.tracking.demo.repository;

import com.vw.customer.tracking.demo.model.Cartype;
import com.vw.customer.tracking.demo.model.Prospect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProspectJpaRepositoryTest {

  @Autowired
  private IProspectJpaRepository prospectRepo;

  @Autowired
  private ICartypeJpaRepository cartypeRepo;

  @Test
  public void saveProspect() {
    //SUV
    //Hatchback
    //Crossover
    //Convertible
    //Sedan
    //Sports Car
    //Coupe
    //Minivan
    //Station Wagon
    //Pickup's

    // CAR TYPE'S
    Cartype suv = new Cartype();
    suv.setCode("SUV");
    suv.setName("SUV");
    suv.setActive(true);

    Cartype hbk = new Cartype();
    hbk.setCode("HBK");
    hbk.setName("Hatchback");
    hbk.setActive(true);

    Cartype cso = new Cartype();
    cso.setCode("CSO");
    cso.setName("Crossover");
    cso.setActive(true);

    suv = cartypeRepo.save(suv);
    hbk = cartypeRepo.save(hbk);
//    cso = carTypeRepo.save(cso);
//    cartypeRepo.flush();

    Prospect migue = new Prospect();
    migue.setName("Miguel Angel");
    migue.setFirstname("Garcia");
    migue.setLastname("Santiago");
    migue.setAddress("Dirección");
    migue.setState("Estado");
    migue.setCity("Ciudad");
    migue.setEmail("migue@fecan.com");
    migue.setPhone("5530555471");
    migue.setComments("Comentarios");
    migue.setCartype(suv);
    migue.setActive(true);

    Prospect erick = new Prospect();
    erick.setName("Erick tonatiuh");
    erick.setFirstname("Garcia");
    erick.setLastname("Martínez");
    erick.setAddress("Dirección");
    erick.setState("Estado");
    erick.setCity("Ciudad");
    erick.setEmail("erick@fecan.com");
    erick.setPhone("5530555471");
    erick.setComments("Comentarios");
    erick.setCartype(hbk);
    erick.setActive(true);

    prospectRepo.save(migue);
    prospectRepo.save(erick);

    prospectRepo.flush();

    Prospect migueG = prospectRepo.findByEmail("migue@fecan.com");
    Prospect erickG = prospectRepo.findByEmail("erick@fecan.com");
    assertEquals("Miguel Angel", migueG.getName());
    assertEquals(2, prospectRepo.findAll().size());
    assertEquals(hbk, erickG.getCartype());
  }
}
