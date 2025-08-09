package com.pahanaedu.model;


public class customer {
    private int accountNumber; // 0 until DB generates it
    private String name;
    private String address;
    private String telephone;
    private int unitsConsumed;

    public customer(String name, String address, String telephone, int unitsConsumed) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.unitsConsumed = unitsConsumed;
    }

    // getters & setters
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getTelephone() { return telephone; }
    public int getUnitsConsumed() { return unitsConsumed; }
}
