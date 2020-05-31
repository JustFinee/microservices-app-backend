package microservicesbackend.expenseaccountservice.dto;

import microservicesbackend.expenseaccountservice.entity.Account;

public class SumDto {

    Account account;
    Integer sum;

    public SumDto(Account account, Integer sum) {
        this.account = account;
        this.sum = sum;
    }

    public SumDto(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
