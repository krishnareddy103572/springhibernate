package org.example;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FlushModeType.COMMIT;


public class ProductDao {
    HibernateTemplate hibtemplate;

    public HibernateTemplate getHibtemplate() {
        return hibtemplate;
    }

    public void setHibtemplate(HibernateTemplate hibtemplate){
        this.hibtemplate = hibtemplate;
    }

    //method to save
@Transactional
    public void saveProduct(Product p){
        hibtemplate.save(p);
    }

    //method to update
    @Transactional
    public void updateProduct(Product p){
        hibtemplate.update(p);
    }

    //method to delete
    @Transactional
    public void deleteProduct(Product p){
        hibtemplate.delete(p);
    }

    //one specific product
    public Product getoneProductById(int productid){
        Product product = hibtemplate.get(Product.class,productid);
        return product;
    }

    //getall products
    public List<Product> getallProducts(){
        List<Product> list = new ArrayList<>();
        list = hibtemplate.loadAll(Product.class);
        return list;
    }
}
