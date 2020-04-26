package microservicesbackend.expenseaccountservice.entity;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    private String name;
    private Long idUser;

    @ManyToOne(optional = false)
    @JoinColumn(name="COLOR_ID")
    Color color;

    Boolean is_income;

    public Category() {
    }

    public Category(String name, Long idUser, Color color, Boolean is_income) {
        this.name = name;
        this.idUser = idUser;
        this.color = color;
        this.is_income = is_income;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Boolean getIs_income() {
        return is_income;
    }

    public void setIs_income(Boolean is_income) {
        this.is_income = is_income;
    }
}
