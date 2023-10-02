package co.istad.sb7springwebmvc.service.impl;

import co.istad.sb7springwebmvc.model.Product;
import co.istad.sb7springwebmvc.repository.ProductRepository;
import co.istad.sb7springwebmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //injection
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;

    @Override
    public void createNewProduct(Product product) {
        productRepository.insertProduct(product);
    }

    @Override
    public void deleteProductById(Integer id) {

    }

    @Override
    public void updateProductById(Integer id, Product updateById) {
        productRepository.updateProduct(id, updateById);
    }

    @Override
    public List<Product> loadProducts() {
        return productRepository.select();
    }

    @Override
    public Product loadProductById(Integer id) {
        return productRepository.selectProductById(id).orElseThrow();
    }

}
