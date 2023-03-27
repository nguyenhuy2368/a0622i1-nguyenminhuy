package com.example.v1.repository.contract;

import com.example.v1.dto.contract.IContractDto;
import com.example.v1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContracRepository extends JpaRepository<Contract,Integer>{
    @Query(value = "SELECT  f.`name` AS facilityName,\n" +
            "             c.`name` AS customerName,\n" +
            "       ct.id AS id,\n" +
            "                 ct.start_date AS startDate,\n" +
            "                   ct.end_date AS endDate,\n" +
            "                    ct.deposit,\n" +
            "                   ((IFNULL(SUM(cd.quantity * af.cost), 0) + f.cost)) AS total\n" +
            "                FROM\n" +
            "                contract ct\n" +
            "                       RIGHT JOIN\n" +
            "                    facility f ON ct.facility_id = f.id\n" +
            "                      LEFT JOIN\n" +
            "                  contract_detail cd ON ct.id = cd.contract_id\n" +
            "                       LEFT JOIN\n" +
            "                   attach_facility af ON cd.attach_facility_id = af.id\n" +
            "                        LEFT JOIN\n" +
            "                customer c ON ct.customer_id = c.id\n" +
            " where ct.is_delete = 1 and f.is_delete = 1 and c.is_delete = 1 " +
            "                GROUP BY ct.id",
            nativeQuery = true,countQuery = "select count(*) from contract")
    Page<IContractDto> findAllDto(Pageable pageable);
}
