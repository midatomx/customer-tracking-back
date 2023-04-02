package com.vw.customer.tracking.demo.repository;

import com.vw.customer.tracking.demo.model.Cartype;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartypeJpaRepositoryTest {

  @Autowired
  private ICartypeJpaRepository repository;

  @Test
  public void saveCarType() {
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

    Cartype con = new Cartype();
    con.setCode("CON");
    con.setName("Convertible");
    con.setActive(true);

    Cartype sdn = new Cartype();
    sdn.setCode("SDN");
    sdn.setName("Sedan");
    sdn.setActive(true);

    con = repository.save(con);
    sdn = repository.save(sdn);

    repository.flush();

    assertEquals(con, repository.findByCode("CON"));
    assertEquals(sdn, repository.findByCode("SDN"));
    assertEquals(2, repository.findAll().size());
  }

}
