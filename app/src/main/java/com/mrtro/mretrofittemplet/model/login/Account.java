
package com.mrtro.mretrofittemplet.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("account_title")
    @Expose
    private String accountTitle;
    @SerializedName("account_type")
    @Expose
    private String accountType;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("currency_type")
    @Expose
    private String currencyType;
    @SerializedName("balance")
    @Expose
    private String balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
