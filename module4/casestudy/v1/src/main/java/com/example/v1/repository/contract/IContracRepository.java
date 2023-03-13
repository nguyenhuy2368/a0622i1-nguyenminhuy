package com.example.v1.repository.contract;

import com.example.v1.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContracRepository extends JpaRepository<Contract,Integer>{
    @Query(value = "select f.name as facilityName, c.name as customerName, ct.id as id, ct.start_date as startDate, ct.end_date as endDate, ct.deposit,((ifnull(sum(cd.quantity * af.cost),0) + f.cost)) as total from contract ct right join facility f on ct.facility_id = f.id left join contract_detail cd on ct.id = cd.contract_id left join attach_facility af on cd.attach_facility_id = af.id left join customer c on ct.customer_id = c.id where ct.is_delete = 1 and f.is_delete = 1 and c.is_delete = 1 group by ct.id", nativeQuery = true,countQuery = "select count(*) from contract")
    Page<>
}
