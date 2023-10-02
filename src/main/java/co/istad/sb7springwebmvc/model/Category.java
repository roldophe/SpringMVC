package co.istad.sb7springwebmvc.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//Three annotations above are pojo
//
@Builder
@AllArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private String description;

}
