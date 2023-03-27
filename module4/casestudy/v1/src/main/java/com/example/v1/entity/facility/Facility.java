package com.example.v1.entity.facility;

import com.example.v1.entity.contract.Contract;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    private Integer isDelete = 1;

    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

}
