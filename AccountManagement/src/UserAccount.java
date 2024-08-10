import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAccount {

    Scanner scanner = new Scanner(System.in);

    List<Accounts> allAccounts = new ArrayList<>();

    public Boolean isLogado = false;

    public Boolean confirmEmail(String userEmail) {
        return userEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public Boolean checkPassword(String userPassword) {
        return userPassword.length() == 6 && userPassword.matches("\\d{6}");
    }

    public void createAccount() {
        System.out.println("Digite seu nome completo: ");
        String userName = scanner.nextLine();
        System.out.println("Digite seu melhor email: ");
        String userEmail = scanner.next();

        if (!confirmEmail(userEmail)) {
            System.out.println("@@ O EMAIL NÃO É VÁLIDO! @@");
            scanner.nextLine();
            return;
        }

        System.out.println("Digite sua senha! Ela deve conter SEIS números: ");
        String userPassword = scanner.next();

        if (!checkPassword(userPassword)) {
            System.out.println("@@ A SENHA DEVE CONTER EXATAMENTE 6 NÚMEROS E NÃO PODE TER LETRAS! @@");
            scanner.nextLine();
            return;
        }

        System.out.println("Muito bem! Digite sua senha novamente para confirmar: ");
        String userConfirmPassword = scanner.next();

        if(!userConfirmPassword.equals(userPassword)){
            System.out.println("@@ VOCÊ DIGITOU UMA SENHA DIFERENTE! TENTE NOVAMENTE! @@");
            scanner.nextLine();
            return;
        }

        Accounts newUserAccount = new Accounts(userName, userEmail, userPassword);
        allAccounts.add(newUserAccount);

        System.out.println("Conta criada com sucesso!");
    }

    public Accounts loginAccount() {
        System.out.println("Digite seu email: ");
        String loginEmail = scanner.next();
        System.out.println("Digite sua senha: ");  
        String loginPassword = scanner.next();
    
        for (Accounts account : allAccounts) {
            if (account.getUserEmail().equalsIgnoreCase(loginEmail) && account.getUserPassword().equals(loginPassword)) {
                System.out.println("Você logou com sucesso! Bem vindo(a) " + account.getUserName());
                return account;
            }
        }
    
        System.out.println("@@ CONTA NÃO ENCONTRADA! @@");
        return null;
    }
    
    
    public void closeScanner() {
        scanner.close();
    }
}