package co.istad.sb7springwebmvc.repository;

import co.istad.sb7springwebmvc.model.Product;
import co.istad.sb7springwebmvc.repository.CategoryProvider.ProductProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper //this repo is the mapper of mybatis
@Repository
public interface ProductRepository {
    //select: return as pojo and list of pojo(Product)

    @Select("SELECT * FROM products ORDER BY id DESC")
    @Results(
            id = "productResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "inStock", column = "in_stock"),
            @Result(property = "categories", column = "id",
                    many = @Many(select = "co.istad.sb7springwebmvc.repository.CategoryRepository.selectProductCategories")),
            @Result(property = "supplier", column = "supplier_id",
                    one = @One(select = "co.istad.sb7springwebmvc.repository.SupplierRepository.selectSupplierById"))
    })
    List<Product> select();

    @Select("SELECT * FROM products WHERE id = #{id}")
    @ResultMap("productResultMap")
    Optional<Product> selectProductById(@Param("id") Integer id);

//    @Insert("""
//            INSERT INTO public.products (name, slug, description, price, in_stock)
//            VALUES (#{p.name}, #{p.slug},#{p.description},#{p.price},#{p.inStock});
//            """)
//    @Result(property = "inStock", column = "in_stock")
    @InsertProvider(ProductProvider.class)
    @Options(useGeneratedKeys = true,keyProperty = "id", keyColumn = "id")
    void insertProduct(@Param("p") Product product);


    @InsertProvider(ProductProvider.class)
    void insertProductCategories(@Param("proId") Integer productId,
                                 @Param("catId") Integer categoryId);

    @UpdateProvider(ProductProvider.class)
    void updateProductById(@Param("p") Product product);
    @Delete("DELETE " +
            "FROM products_categories " +
            "WHERE product_id=#{proId}")
    void deleteProductCategories(@Param("proId") Integer productID);

//    @Update("""
//            UPDATE products
//            SET name=#{p.name},
//                slug=#{p.slug},
//                description=#{p.description},
//                price=#{p.price},
//                in_stock=#{p.inStock}
//                WHERE id=#{id};
//            """)
//    @Result(property = "inStock", column = "in_stock")
//    void updateProduct(@Param("id") Integer id,@Param("p") Product product);
}
