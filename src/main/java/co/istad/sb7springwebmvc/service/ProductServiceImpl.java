package co.istad.sb7springwebmvc.service;

import co.istad.sb7springwebmvc.model.Product;
import co.istad.sb7springwebmvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    public final ProductRepository  productRepository;
    @Override
    public void createNewProduct(Product product) {

    }

    @Override
    public void deleteProductById(Integer id) {

    }

    @Override
    public void updateProductById(Integer id, Product updateById) {

    }

    @Override
    public List<Product> loadProducts() {
        return productRepository.select();
    }

    @Override
    public Product loadProductById(Integer id) {
        return productRepository.selectProductById(id).orElseThrow();
    }


    // private List<Product> products;

    /*public ProductService() {
        products = new ArrayList<>();
        products.add(Product.builder()
                .id(1)
                .name("Dell Desktop")
                .slug(SlugUtil.toSlug("Dell Desktop"))
                .price(999.0)
                .inStock(true)
                .build());
        products.add(Product.builder()
                .id(2)
                .name("Iphone 15Pro Max")
                .slug(SlugUtil.toSlug("Iphone 15Pro Max"))
                .price(600.00)
                .inStock(true)
                .build());
        products.add(Product.builder()
                .id(3)
                .name("MacBook Pro 14inch")
                .slug(SlugUtil.toSlug("MacBook Pro 14inch"))
                .price(555.0)
                .inStock(false)
                .build());
        products.add(Product.builder()
                .id(4)
                .name("Iphone 12Pro Max")
                .slug(SlugUtil.toSlug("Iphone 12Pro Max"))
                .price(999.0)
                .inStock(true)
                .build());


    public List<Product> loadProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        if (product != null) {
            product.setSlug(SlugUtil.toSlug(product.getName()));
            products.add(product);

            return product;
        }
        throw new RuntimeException("Product cannot be added");
    }

    public Product updateProduct(Integer id, Product newProduct) {
        return products.stream().filter(product -> product.getId().equals(id)).peek(product -> {
            product.setName(newProduct.getName());
            product.setSlug(SlugUtil.toSlug(newProduct.getName()));
            product.setPrice(newProduct.getPrice());
            product.setInStock(newProduct.getInStock());

        }).findFirst().orElseThrow();
    }

    public Product loadProductById(Integer id) {
        return products.stream().
                filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Product not found!")
                );
    }

    public List<Product> searchProduct(String name, Boolean status) {
        return products.stream().filter(product -> product.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase()) && product.getInStock().equals(status))
                .toList();
    }

    public void DeleteProductById(Integer id) {
        products = products.stream()
                .filter(product -> !product.getId().equals(id))
                .collect(Collectors.toList());
    }

     */

}
