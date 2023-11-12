package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository {
    @SqlUpdate(
            """
                INSERT INTO CUSTOMER (id, first_name, last_name, manager_id) 
                VALUES (DEFAULT, :firstName, :lastName, :manager.id)
                """)
    void createCustomer(@BindBean Customer customer);
}
