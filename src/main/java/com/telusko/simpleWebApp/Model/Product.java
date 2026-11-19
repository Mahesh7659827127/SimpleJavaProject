package com.telusko.simpleWebApp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data //Lombok automatically generates getters, setters, toString(), equals(), hashcode()- generates hashcode for code
@AllArgsConstructor  // It generates a constructor containing all class variables as parameters, this is feature of lombok
@NoArgsConstructor   //public Product(int prodId, String proName, int price) {
                         //    this.prodId = prodId;
                         //    this.proName = proName;
                        //    this.price = price;
//}
@Entity //this annotation is to create the table
public class Product {

    @Id //This is for primary key
    private int prodId;
    private String proName;
    private int price;


    //Here we need getters and setter to access but we can achieve it by using projectlombok dependency
}
