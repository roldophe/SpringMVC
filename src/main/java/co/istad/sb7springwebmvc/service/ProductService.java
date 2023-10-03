package co.istad.sb7springwebmvc.service;

import co.istad.sb7springwebmvc.dto.CreateProductDto;
import co.istad.sb7springwebmvc.dto.UpdateProductDto;
import co.istad.sb7springwebmvc.model.Product;

import java.util.List;


public interface ProductService {
    void createNewProduct(CreateProductDto  createProductDto);
    void deleteProductById(Integer id);
    void updateProductById(Integer id, UpdateProductDto updateProductDto);
    List<Product> loadProducts();
    Product loadProductById(Integer id);
}
