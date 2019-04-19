package ee.anddero.carservice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "car_tbl")
@Getter
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long id;
    
    @Column(name = "car_name")
    @Setter
    private String name;
    
    Car() {} // Keep the default constructor for JPA
    
    public Car(String name) {
        this.name = name;
    }
}
