package com.example.v1.repository.customer;

import com.example.v1.dto.customer.ICustomerDto;
import com.example.v1.entity.customer.Customer;
import com.example.v1.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select c.* from `customer` c inner join `customer_type` ct " +
            "on c.customer_type_id = ct.id " +
            "where c.name like %:name% and c.email like %:email% and ct.name like %:typeName% and c.is_delete= 1", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerType(@Param("name") String name,
                                                     @Param("email") String email,
                                                     @Param("typeName") String typeName,
                                                     Pageable pageable);

    @Query(value = "select * from `customer` where id=:id and is_delete = 1", nativeQuery = true)
    Optional<Customer> findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update customer set is_delete = 0 where id = :id", nativeQuery = true)
    void remove(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customer ( name, date_of_birth,gender,id_card, phone_number, email, address, customer_type_id, is_delete)\n" +
            "VALUE ( :name, :date_of_birth,:gender,:id_card, :phone_number, :email, :address, :customer_type_id, 1);\n;", nativeQuery = true)
    void save(@Param("name") String name,
              @Param("date_of_birth") String dateOfBirth,
              @Param("gender") int gender,
              @Param("id_card") String idCard,
              @Param("phone_number") String phoneNumber,
              @Param("email") String email,
              @Param("address") String address,
              @Param("customer_type_id") int customerTypeId);

    @Query(value = "select * from customer_type ", nativeQuery = true)
    List<CustomerType> getCustomerType();


    @Query(value = "SELECT customer.address, customer.date_of_birth AS birthday, customer.email, customer.`name`, \n" +
            "contract.end_date AS contractEndDate, contract.start_date AS contractStartDate FROM customer \n" +
            "INNER JOIN contract ON customer.id = contract.customer_id \n" +
            "WHERE contract.end_date > now() \n" +
            "GROUP BY customer.id \n" +
            "ORDER BY customer.id ASC ", nativeQuery = true, countQuery = "select count(*) from customer")
    Page<ICustomerDto> getCustomerUsing(Pageable pageable);

    @Query(value = "select* from customer where customer.is_delete = 1", nativeQuery = true)
    List<Customer> findAll();
}
