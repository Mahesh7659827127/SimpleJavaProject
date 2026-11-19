package com.telusko.simpleWebApp.Repository;

import com.telusko.simpleWebApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    //Product is class with we are working and integer is primary key data type


}
//we have not created or this class is empty any queries still getting data how
//we have extended from class JpaRepositoty
//spring.jpa.show-sql=true this app.property allow us see the query

// In the interfaces we can't define the methods for that we need to declare it somewhere
//but spring data jpa will take of that
