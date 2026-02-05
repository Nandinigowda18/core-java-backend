package org.example;

import java.nio.file.attribute.UserPrincipal;
import java.sql.PreparedStatement;

public class Service {


    Product[] products = new Product[5]; int idx=0;

    public boolean addProduct(String productId, String productName, double price, int quantity ){
        if (idx >= products.length) {
            System.out.println("Product list is full");
            return false;
        }
        if(productId.trim().length()==0 || productName.length()==0 || quantity < 0 || price <=0){
            System.out.println("invalid credentials");
            return false;
        }
        if(getByID(productId) != null){
            System.out.println("Id Already exists");
            return false;
        }
        products[idx] = new Product(productId,productName ,price, quantity);
        System.out.println("Product Added succesfully");
        System.out.println("id "+productId+" Name "+productName+"price "+price+"quantity "+quantity);
        idx++;
        return true;
    }

    //GET
    public Product getByID(String productId){

       for(int i=0;i<idx;i++){

           if(products[i].productId.equalsIgnoreCase(productId)){
               return products[i];
           }

       }

        return null;
    }


    //Put
    public  boolean updateProduct(String productId,String NewName, Double newprice,Integer NewQunatity ){

        boolean updated= false;

      if(productId.trim().isEmpty() || productId == null ){
          System.out.println("invalid id");
          return false;
      }
      Product product = getByID(productId);


      if(product== null){
          System.out.println("Cant find product");
          return false;
      }

    if(NewName != null && !NewName.trim().isEmpty() ){
        product.productName = NewName;
        updated= true;
        System.out.println("Name updated successfully");

    }
        if(NewQunatity != null && NewQunatity>=0  ){
            product.quantity = NewQunatity;
            updated= true;
            System.out.println("Quantity updated successfully");
        }

        if( newprice !=null && newprice >=0  ){
            product.price = newprice;
            updated= true;
            System.out.println("Price updated successfully");
        }

     if(!updated){
         System.out.println("Product Not Updated");
     }else{
         System.out.println("Product updated successfully");
     }

        return updated;

    }


    //Delete

    public boolean delete(String productId){


        if(productId == null && productId.trim().isEmpty()){
            System.out.println("No product with the given Id found");
            return false;
        }

     for(int i=0;i<idx;i++){
         if(products[i].productId.equalsIgnoreCase(productId)){

             for(int j=i ; j<idx -1; j++){
                 products[j]= products[j+1];

             }
             products[idx] = null;
             idx--;

         }

     }
     if(!true){
         System.out.println("Delete Unsuccessfull");
     }else{
         System.out.println("Delete successfull "+productId);
     }


     return true;


    }


    //List of all

    public void list(){

        if(idx <=0){
            System.out.println("Nothing to Display");
        }

        for(int i=0; i<idx ;i++){

         System.out.println(products[i].productName +" "+products[i].quantity);

        }

    }

}
