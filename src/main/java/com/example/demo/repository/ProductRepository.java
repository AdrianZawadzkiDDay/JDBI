package com.example.demo.repository;


import java.util.List;

import com.example.demo.entities.Product;
import jakarta.validation.Valid;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(Product.class)
public interface ProductRepository {

    @Transaction
    @SqlUpdate("insert into jdbi_db.product (name, description, price, qty) values(:name, :description, :price, :qty);")
    @GetGeneratedKeys
    int insert(@BindBean Product product);

    @SqlQuery("select * from jdbi_db.product where id = :id;")
    Product getById(@Bind("id") long id);

    @SqlQuery("select * from jdbi_db.product;")
    List<Product> getAllProducts();


    @Transaction
    @SqlUpdate("update jdbi_db.product set name = :name, description = :description, price = :price, qty = :qty where id = :id;")
    int updateProductById(@BindBean @Valid Product product);

    @Transaction
    @SqlUpdate("delete from jdbi_db.product where id = :id;")
    int deleteProductById(long id);

}
