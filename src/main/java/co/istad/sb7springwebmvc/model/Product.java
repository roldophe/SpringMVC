package co.istad.sb7springwebmvc.model;

import lombok.*;

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
    private Double price;
    private Boolean inStock;
    //Follow rule encapsulation (Getter Setter and NoArgConstructor =POJO)
}
