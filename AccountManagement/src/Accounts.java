
import java.util.ArrayList;
import java.util.List;

public class Accounts {

    private String userName;
    private String userEmail;
    private String userPassword;
    private double userBalance;
    private List<AccountStatement> depositStatement = new ArrayList<>();
    private List<AccountStatement> withdrawStatement = new ArrayList<>();

    public Accounts(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public void deposit(double amount, String dateTime) {
        if (amount > 0) {
            userBalance += amount;
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + userBalance);
            depositStatement.add(new AccountStatement(amount, dateTime));
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    public void withdraw(double amount, String dateTime) {
        if (amount > 0 && userBalance >= amount) {
            userBalance -= amount;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + userBalance);
            withdrawStatement.add(new AccountStatement(amount, dateTime));
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void checkStatement() {
        if (!depositStatement.isEmpty() || !withdrawStatement.isEmpty()) {
            System.out.println("Entrada: \n");
            if (!depositStatement.isEmpty()) {
                for (AccountStatement deposit : depositStatement) {
                    System.out.println("==== Depósito de R$" + deposit.getAmount() + " realizado em " + deposit.getDateTime() + " ====");
                }
            } else {
                System.out.println("Nenhuma entrada registrada.");
            }
    
            System.out.println("\nSaída: \n");
            if (!withdrawStatement.isEmpty()) {
                for (AccountStatement withdraw : withdrawStatement) {
                    System.out.println("==== Saque de R$" + withdraw.getAmount() + " realizado em " + withdraw.getDateTime() + " ====");
                }
            } else {
                System.out.println("Nenhuma saída registrada.");
            }
        } else {
            System.err.println("@@ EXTRATO VAZIO @@");
        }
    }
}    