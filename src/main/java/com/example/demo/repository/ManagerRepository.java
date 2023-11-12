package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

import com.example.demo.model.Customer;
import com.example.demo.model.Manager;
import com.example.demo.repository.reducer.ManagerCustomerReducer;
import org.jdbi.v3.core.result.LinkedHashMapRowReducer;
import org.jdbi.v3.core.result.RowView;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowReducer;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository {
    @SqlUpdate("""
            INSERT INTO manager VALUES (DEFAULT, :firstName, :lastName, :bonus)
        """)
    @GetGeneratedKeys
    int createNewManager(String firstName, String lastName, Integer bonus);

    @SqlUpdate("""
                INSERT INTO manager VALUES (DEFAULT, :firstName, :lastName, :bonus)
        """)
    @GetGeneratedKeys
    int createNewManager(@BindBean Manager manager);

    @SqlQuery("SELECT * FROM manager")
    @RegisterBeanMapper(Manager.class)
    void findAll(Consumer<Manager> consumer);


    @SqlQuery("""
        SELECT m.id m_id, m.first_name m_first_name, m.last_name m_last_name, m.bonus m_bonus,
               c.id c_id, c.first_name c_first_name, c.last_name c_last_name,  c.birth_date c_birth_date,
               c.email c_email, c.phone c_phone, c.manager_id c_manager_id
               FROM manager m JOIN customer c ON c.manager_id = m.id
               WHERE m.id = :id
        """)
    @RegisterBeanMapper(value = Manager.class, prefix = "m")
    @RegisterBeanMapper(value = Customer.class, prefix = "c")
    @UseRowReducer(ManagerCustomerReducer.class)
    Manager getManager(Integer id);

}
