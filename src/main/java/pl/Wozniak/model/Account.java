package pl.Wozniak.model;

public class Account {

    private double amount;
    private int number;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", number=" + number +
                '}';
    }
}