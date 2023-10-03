package co.istad.sb7springwebmvc.service.impl;

import co.istad.sb7springwebmvc.dto.CreateProductDto;
import co.istad.sb7springwebmvc.dto.UpdateProductDto;
import co.istad.sb7springwebmvc.model.Category;
import co.istad.sb7springwebmvc.model.Product;
import co.istad.sb7springwebmvc.model.Supplier;
import co.istad.sb7springwebmvc.repository.ProductRepository;
import co.istad.sb7springwebmvc.service.ProductService;
import co.istad.sb7springwebmvc.utils.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //injection
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository; //injection repository

    @Transactional
    @Override
    public void createNewProduct(CreateProductDto createProductDto) {
        //Map DTO to POJO
        Product product = Product.builder()
                .name(createProductDto.name())
                .description(createProductDto.description())
                .price(createProductDto.price())
                .inStock(createProductDto.inStock())
                .supplier(Supplier.builder().id(createProductDto.supplierId()).build())
                .build();
        if(product.getName()!=null){
                product.setSlug(SlugUtil.toSlug(createProductDto.name()));
        }
        //Start inserting a product
        productRepository.insertProduct(product);
        System.out.println("INSERT PRODUCT ID: " + product.getId());
        //Start inserting a product category
        createProductDto.categoryIds().forEach(id -> productRepository.insertProductCategories(product.getId(), id));
    }

    @Transactional
    @Override
    public void updateProductById(Integer id, UpdateProductDto updateProductDto) {
        Product updateProduct = Product.builder()
                .id(id)
                .name(updateProductDto.name())
                .slug(SlugUtil.toSlug(updateProductDto.name()))
                .description(updateProductDto.description())
                .supplier(Supplier.builder().id(updateProductDto.supplierId()).build())
                .build();
        productRepository.updateProductById(updateProduct);
        System.out.println("UPDATE PRODUCT ID: " + updateProduct.getId());
        //Reset product category
        productRepository.deleteProductCategories(id);
        //Start inserting a product category
        updateProductDto.categoryIds().forEach(cateId -> productRepository.insertProductCategories(updateProduct.getId(), cateId));

    }

    @Override
    public void deleteProductById(Integer id) {

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
