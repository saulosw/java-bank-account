import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    UserAccount user = new UserAccount();
    Accounts loggedInAccount = null;

    public void menuOperations() {
        while (true) {
            System.out.println("""
                               Bem-vindo(a) ao Sistema Bancário! \n
                               Digite uma das opções abaixo:
                               (c) Criar Conta
                               (l) Logar na Conta
                               (d) Depositar
                               (s) Sacar
                               (t) Total na Conta
                               (e) Exibir Extrato
                               (x) Fechar

                               ↓
                               """);

            String option = scanner.next();

            if (option.equalsIgnoreCase("c")) {
                user.createAccount();
            } else if (option.equalsIgnoreCase("l")) {
                loggedInAccount = user.loginAccount();
            } else if (option.equalsIgnoreCase("d") && loggedInAccount != null) {
                AccountOperations operations = new AccountOperations(loggedInAccount);
                operations.deposit(getAmountInput());
            } else if (option.equalsIgnoreCase("s") && loggedInAccount != null) {
                AccountOperations operations = new AccountOperations(loggedInAccount);
                operations.withdraw(getAmountInput());
            } else if (option.equalsIgnoreCase("t") && loggedInAccount != null) {
                AccountOperations operations = new AccountOperations(loggedInAccount);
                operations.checkBalance();
            } else if (option.equalsIgnoreCase("e") && loggedInAccount != null) {
                AccountOperations operations = new AccountOperations(loggedInAccount);
                operations.checkStatement();
            } else if (option.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Opção inválida ou nenhuma conta logada.");
            }
        }
    }

    private double getAmountInput() {
        System.out.println("Digite o valor: ");
        return scanner.nextDouble();
    }
}