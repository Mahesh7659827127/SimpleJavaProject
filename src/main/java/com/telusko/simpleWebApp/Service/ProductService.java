
//This service layer is to create the business logic

package com.telusko.simpleWebApp.Service;

import com.telusko.simpleWebApp.Model.Product;
import com.telusko.simpleWebApp.Repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service // this service annotation is @Component behind the scenes
//@Service is used to identify a class that contains business logic and managed by spring IOC container.
//@Component "This class should be managed by the Spring IoC container."
public class ProductService {

    @Autowired     //here we are connecting repository layer with service layer
    ProductRepo Repo;
    //Here we are creating dummy data in product object

  /*  this commented because we are adding repository layer
  List<Product> products = new ArrayList<>(Arrays.asList( //we are writing new ArrayList<> to make array mutable
            new Product(101, "iPhone", 50000),
            new Product(102, "canon camera",70000),
            new Product(103,"Headset",2599))); */
    //this is the method that returns list of product objects
    public List<Product> getProducts() {
        //return products; //cause we are using repo
        return Repo.findAll();
    }

    public Product getProductById(int productID) {//it will returns the product objects
       /* return products.stream()
                .filter(p ->p.getProdId() == productID) //watch stream API to get more info
                .findFirst().orElse(new Product(100,"No Items",0));*/
        return Repo.findById(productID).orElse(new Product(000,"no item",00));
    }

    public void addProduct(Product product){//Here, the method accepts one Product object as an argument.
        //products.add(product);
        Repo.save(product); //To save the records
    }

    public void updateProduct(Product product){
           /* for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProdId() == product.getProdId()) {
                    products.set(i, product);
                    return;//Add return; after products.set(i, product) to stop searching once the product is updated.
                }
            }*/
        Repo.save(product);//this will check the all records and if exist it will update
        }

    public void deleteProduct(int productID) {
        //products.removeIf(p -> p.getProdId() ==productID);This logic will also work
       /* for(int i=0; i<products.size();i++){
            if(products.get(i).getProdId() == productID){
                products.remove(i);
                return;
            }
        }*/
        Repo.deleteById(productID);

    }
 }

//products.get(i) → Gets a Product object from the ArrayList, so it is access with index
//.getProdId() → Gets the product ID from that Product object from accessed index