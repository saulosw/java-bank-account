
class AccountStatement {

    private double amount;
    private String dateTime;

    public AccountStatement(double amount, String dateTime) {
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public String getDateTime() {
        return dateTime;
    }
}
