//This controller layer to accept and respond to the client

package com.telusko.simpleWebApp.Controller;

import com.telusko.simpleWebApp.Model.Product;
import com.telusko.simpleWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;
    @GetMapping("/products")
    public List<Product> getProducts(){

        return service.getProducts();

    }
    @GetMapping("/products/{productID}")
    public  Product getProductByID(@PathVariable int productID){ //this ID is sending from the client
        return  service.getProductById(productID);//we are passing id to service layer from the client
    }
    @PostMapping("/products")//look at the annotations here @RequestMapping and @PostMapping
    public void addProduct(@RequestBody Product product){//Observe here the annotations @RequestBody
        System.out.println(product);
        service.addProduct(product);
    }
    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product){
        System.out.println(product);
        service.updateProduct(product);
    }
    @DeleteMapping("/deleteProd/{productID}")
    public void deleteProduct(@PathVariable int productID){
        service.deleteProduct(productID);
    }
}
// If a controller wants the data it will ask the service layer to for data not from the database
//you should not be writing any business logic inside the Controller
// Controller is just doing accepting the request and responding to the client
//We create a service layer to write the business logic
//@pathvariable is used for @Pathmapping or dynamic routing remember the annotation
//@By this annotation ->Spring Boot extracts 101 from the URL and assigns it to the id variable.
//@RequestMapping ->It can handle different HTTP methods such as GET, POST, PUT and DELETE.
//@PostMapping ->It is a specialized shortcut for @RequestMapping with handling only POST requests.
//@RequestBody  → Gets data from the HTTP request body.