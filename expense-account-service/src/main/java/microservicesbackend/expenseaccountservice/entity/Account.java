package microservicesbackend.expenseaccountservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    private String name;

    private Long idUser;

    private boolean isVisible;

    public Account() {
    }

    public Account(String name, Long idUser,boolean isVisible) {
        this.name = name;
        this.idUser = idUser;
        this.isVisible = isVisible;
    }

    public Long getIdUser() {
        return idUser;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
