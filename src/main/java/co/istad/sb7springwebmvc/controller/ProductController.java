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

   /* @RequestMapping(method= RequestMethod.GET, value = "/products")
    public String getProduct(){
        return "Get all products using long hand.";
    }*/

    /*@GetMapping("/products")
    public String getProduct(){
        return "Get product using shorthand.";
    }*/

    private final ProductService productService;

    @GetMapping //get all products
    public List<Product> getProducts() {
        return productService.loadProducts();
    }
    @GetMapping("/{id}/{slug}")
    public Product getProductById(@PathVariable("id") Integer proId,
                                  @PathVariable String slug) {
//        System.out.println("Product id: " + id);
//        System.out.println("Product slug: " + slug);
        return productService.loadProductById(proId);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping //Create new product
    public void createNewProduct(@RequestBody Product product) {
        System.out.println(product);
//        Product newProduct = Product.builder()
//                .id(5)
//                .name("Samsung Ultra23")
//                .price(1299.0)
//                .inStock(true)
//                .build();
        productService.createNewProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")//Update product
    public void updateOldProduct(@PathVariable Integer id,
                                 @RequestBody Product newProduct) {
//        System.out.println(newProduct);
//        Product updateProduct = Product.builder()
//                .name("SmartWatch Air3")
//                .price(499.9)
//                .inStock(false)
//                .build();
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
