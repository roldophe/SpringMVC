package co.istad.sb7springwebmvc.controller;

import co.istad.sb7springwebmvc.model.Product;
import co.istad.sb7springwebmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping //get all products
    public List<Product> loadProducts() {
        return productService.loadProducts();
    }
    @GetMapping("/{id}")
    public Product loadProductById(@PathVariable("id") Integer proId) {
        return productService.loadProductById(proId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Create new product
    public void createNewProduct(@RequestBody Product product) {
        System.out.println(product);
        productService.createNewProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")//Update product
    public void updateOldProduct(@PathVariable Integer id,
                                 @RequestBody Product newProduct) {
        productService.updateProductById(id, newProduct);
    }

    @PatchMapping
    public String updateProductPartially() {
        return "Update product partially";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false, defaultValue = "") String name, @RequestParam(required = false, defaultValue = "true") Boolean status) {
        System.out.println("request name: " + name);
        System.out.println("request status: " + status);
        return null;
    }
}
