package com.example.v1.repository.contract;

import com.example.v1.dto.contract.IContractDetailDto;
import com.example.v1.entity.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "SELECT attach_facility.`name` AS nameDto,attach_facility.unit AS unitDto, \n" +
            "sum(ifnull(contract_detail.quantity, 0)) AS quantityDto,\n" +
            "attach_facility.`status` AS statusDto, attach_facility.cost AS costDto \n" +
            "FROM contract_detail INNER JOIN attach_facility\n" +
            "ON contract_detail.attach_facility_id = attach_facility.id \n" +
            "WHERE contract_detail.contract_id = :idFind GROUP BY attach_facility.id", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);

    @Query(value = "SELECT * FROM contract_detail " +
            "WHERE contract_detail.contract_id = :idFind ", nativeQuery = true)
    List<ContractDetail> getListAttachContract(@Param("idFind") Integer id);
}
