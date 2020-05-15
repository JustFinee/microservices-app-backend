package microservicesbackend.expenseaccountservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","category"})
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcategoryId;

    private String name;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    public Subcategory() {
    }

    public Subcategory(String name, Category Category) {
        this.name = name;
        this.category = Category;
    }

    public long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonBackReference
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
