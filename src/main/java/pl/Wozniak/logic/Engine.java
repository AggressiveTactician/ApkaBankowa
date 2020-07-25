package pl.Wozniak.logic;

import pl.Wozniak.model.Account;
import pl.Wozniak.model.User;

import java.util.Scanner;

public class Engine {

    private User[] users = new User[10];

    public void launch() {
        System.out.println("Witamy w naszym banku X");
        System.out.println("Podaj swój login: ");
        Scanner scanner = new Scanner(System.in);
        numberGenerator generator = new numberGenerator(users);
        String login = scanner.next();
        User checkUser = findUser(login);
        if (checkUser == null) {
            System.out.println("Loginu nie znaleziono. Utworzono nowe konto");
            User newUser = newUser(generator, login);
            addUser(newUser);
        }
    }

    private User newUser(numberGenerator generator, String login) {
        User newUser = new User();
        newUser.setLogin(login);
        Account newAccount = createAccount(generator);
        newUser.setAccount(newAccount);
        return newUser;
    }

    private void addUser(User newUser) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = newUser;
                break;
            }
        }
    }

    private Account createAccount(numberGenerator generator) {
        Account newAccount = new Account();
        newAccount.setNumber(generator.generateNumber());
        newAccount.setAmount(0d);
        return newAccount;
    }

    private User findUser(String login) {
        User checkUser = null;
        for (User user : users) {
            if (user != null && login.equals(user.getLogin())) {
                checkUser = user;
                break;
            }
        }
        return checkUser;
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}