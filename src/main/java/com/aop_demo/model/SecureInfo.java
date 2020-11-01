package com.aop_demo.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class SecureInfo {

    private static final Logger logger = LogManager.getLogger(SecureInfo.class);

    private int id;

    private User user;
    private Account account;

    private String bankingHistory;
    private Double moneyTotal;

    public SecureInfo() {
    }

    public SecureInfo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getBankingHistory() {
        return bankingHistory;
    }

    public void setBankingHistory(String bankingHistory) {
        this.bankingHistory = bankingHistory;
    }

    public Double getMoneyTotal() {
        logger.debug(getClass() + " getMoneyTotal()");
        return moneyTotal;
    }

    public void setMoneyTotal(Double moneyTotal) {
        logger.debug(getClass() + " setMoneyTotal()");
        this.moneyTotal = moneyTotal;
    }

    @Override
    public String toString() {
        return "SecureInfo{" +
                "id=" + id +
                ", user=" + user +
                ", account=" + account +
                ", bankingHistory='" + bankingHistory + '\'' +
                ", moneyTotal=" + moneyTotal +
                '}';
    }
}
