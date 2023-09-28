package co.istad.sb7springwebmvc.service;

import co.istad.sb7springwebmvc.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {


    void createNewProduct(Product product);
    void deleteProductById(Integer id);
    void updateProductById(Integer id, Product updateById);
    List<Product> loadProducts();
    Product loadProductById(Integer id);
}
