package com.example.v1.repository.facility;

import com.example.v1.entity.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from facility " +
            "where name like %:name% and facility_type_id like %:typeName% and is_delete = 1"
            , nativeQuery = true)
    Page<Facility> findByNameAndFacilityType(@Param("name") String name,
                                             @Param("typeName") String typeName,
                                             Pageable pageable);

    @Query(value = "select * from facility where id=:id and is_delete = 1", nativeQuery = true)
    Optional<Facility> findById(@Param("id") int id);

    @Query(value = "SELECT* from facility where facility.is_delete = 1", nativeQuery = true)
    List<Facility> findAll();
}
