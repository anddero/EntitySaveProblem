package ee.anddero.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepo carRepo;
    
    @Autowired
    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }
    
    @GetMapping(value = "/resource")
    public ResponseEntity visit() {
        Car car = carRepo.save(new Car("VolksWagen"));
        
        car.setName("Audi");
        //carRepo.save(car); // without this the name is not updated
        
        return ResponseEntity.ok().build();
    }
}
