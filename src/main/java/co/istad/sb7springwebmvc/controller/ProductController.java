package co.istad.sb7springwebmvc.controller;

import co.istad.sb7springwebmvc.dto.CreateProductDto;
import co.istad.sb7springwebmvc.dto.UpdateProductDto;
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
    public void createNewProduct(@RequestBody CreateProductDto createProductDto) {
        System.out.println(createProductDto.supplierId());
        System.out.println(createProductDto.categoryIds());
        productService.createNewProduct(createProductDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")//Update product
    public void updateOldProductById(@PathVariable Integer id,
                                 @RequestBody UpdateProductDto updateProductDto) {
        System.out.println("ID FROM DTO: "+updateProductDto.supplierId());
        System.out.println("ID FROM DTO: "+updateProductDto.categoryIds());
        productService.updateProductById(id, updateProductDto);
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
