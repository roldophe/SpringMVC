package co.istad.sb7springwebmvc.dto;

import java.util.List;

public record CreateProductDto(String name,
                               String description,
                               Double price,
                               Boolean inStock,
                               Integer supplierId,
                               List<Integer> categoryIds
                                ) {

}
