package com.restapi.service.repository;

import com.restapi.service.entity.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerServiceRepository extends JpaRepository<CustomerService, Integer>{
    @Query("UPDATE CustomerService c SET c.status = 'enable' WHERE c.customerid = :customerid AND c.service.id = :serviceid")
    CustomerService findByCustomeridandEnable(@Param("customerid") Integer customerid,@Param("serviceid") Integer serviceid);

    @Query("UPDATE CustomerService c SET c.status = 'disable' WHERE c.customerid = :customerid AND c.service.id = :serviceid")
    CustomerService findByCustomeridandDisable(@Param("customerid") Integer customerid,@Param("serviceid") Integer serviceid);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CustomerService c WHERE c.service.id = :serviceid")
    Object existsByServiceid(@Param("serviceid") Integer serviceid);

    @Query("SELECT c FROM CustomerService c WHERE c.customerid = :customerid AND c.service.id = :serviceid")
    CustomerService findByCustomeridAndServiceid(@Param("customerid") Integer customerid,@Param("serviceid") Integer serviceid);
}
