package co.istad.sb7springwebmvc.repository.CategoryProvider;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.context.annotation.EnableMBeanExport;

public class CategoryProvider implements ProviderMethodResolver {
    private String TB_CATEGORY = "categories";

    public String selectProductCategories() {
        return new SQL() {{
            SELECT("*");
            FROM(TB_CATEGORY + " c");
            INNER_JOIN("products_categories pc ON pc.category_id = c.id");
            WHERE("pc.product_id =#{productId}");
        }}.toString();
    }
    public String selectCategories(){
        return new
                SQL(){{
                    SELECT("*");
                    FROM(TB_CATEGORY);
                }}.toString();
    }
//    public String insertCategory(){
//        return new SQL(){{
//            INSERT_INTO(TB_CATEGORY);
//            INTO_COLUMNS("name", "description");
//            VALUES("#{name}","#{name}");
//        }}.toString();
//    }
}
