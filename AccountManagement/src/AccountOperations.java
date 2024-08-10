import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountOperations {

    private Accounts loggedInAccount;
    private DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public AccountOperations(Accounts account) {
        this.loggedInAccount = account;
    }

    public void deposit(double amount) {
        String date = LocalDateTime.now().format(formatDateTime);
        loggedInAccount.deposit(amount, date);
    }

    public void withdraw(double amount) {
        String date = LocalDateTime.now().format(formatDateTime);
        loggedInAccount.withdraw(amount, date);
    }

    public void checkBalance() {
        System.out.println("Saldo atual: " + loggedInAccount.getUserBalance());
    }

    public void checkStatement() {
        loggedInAccount.checkStatement();
    }
}
