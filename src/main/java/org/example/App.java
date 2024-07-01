package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.Entity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "My Spring Hibernate project started..!" );

        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        ProductDao productDao = context.getBean("productDao",ProductDao.class);

        Product product = new Product();
        product.setProductid(49);
        product.setProductname("BMW");
        product.setProductprice(11155000);


      // productDao.saveProduct(product);//save

//       product.setProductprice(123456);
//       product.setProductname("Ferrari"); //UPDATE
//       product.setProductid(45);
//       productDao.updateProduct(product);

        //productDao.deleteProduct(product); //delete

        Product pd =productDao.getoneProductById(45);
        productDao.deleteProduct(pd);


        System.out.println(product);
    }
}
