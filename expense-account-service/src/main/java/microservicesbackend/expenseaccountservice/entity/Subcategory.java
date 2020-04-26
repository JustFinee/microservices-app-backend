package microservicesbackend.expenseaccountservice.entity;


import javax.persistence.*;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subcategoryId;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name="CATEGORY_ID")
    private Category Category;

    public Subcategory() {
    }

    public Subcategory(String name, Category Category) {
        this.name = name;
        this.Category = Category;
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

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        this.Category = category;
    }
}
