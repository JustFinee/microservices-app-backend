package microservicesbackend.expenseaccountservice.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class Expence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenceId;

    private long idUser;

    @ManyToOne(optional = false)
    @JoinColumn(name="ACCOUNT_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account account;

    private int amount;
    private LocalDateTime date;
    private String note;

    @ManyToOne(optional = true)
    @JoinColumn(name="SUBCATEGORY_ID")
    private Subcategory subcategory;

    private Type type;

    public Expence() {
    }

    public Expence(long idUser,Account account, int amount, LocalDateTime date, String note, Subcategory subcategory, Type type) {
        this.idUser = idUser;
        this.account = account;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.subcategory = subcategory;
        this.type = type;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getExpenceId() {
        return expenceId;
    }

    public void setExpenceId(long expenceId) {
        this.expenceId = expenceId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
