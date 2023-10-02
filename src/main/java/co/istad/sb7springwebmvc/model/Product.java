package co.istad.sb7springwebmvc.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//Three annotations above are pojo
//
@Builder
@AllArgsConstructor
//@ToString
public class Product {
    private Integer id;
    private String slug;
    private String name;
    private String description;
    private Double price;
    private Boolean inStock;
    //Follow rule encapsulation (Getter Setter and NoArgConstructor =POJO)
    private Supplier supplier;
    private List<Category> categories;
}
