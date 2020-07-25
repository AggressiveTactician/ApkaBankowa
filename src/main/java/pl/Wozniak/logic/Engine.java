package pl.Wozniak.logic;

import pl.Wozniak.model.Account;
import pl.Wozniak.model.User;
import pl.Wozniak.userList;

import java.util.Scanner;

public class Engine {

    private userList userList = new userList();

    public void launch() {
        System.out.println("Witamy w naszym banku X");
        System.out.println("Podaj swój login: ");
        Scanner scanner = new Scanner(System.in);
        numberGenerator generator = new numberGenerator(userList.getAll());
        String login = scanner.next();
        User checkUser = userList.findUser(login);
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
        userList.addUser(newUser);
    }

    private Account createAccount(numberGenerator generator) {
        Account newAccount = new Account();
        newAccount.setNumber(generator.generateNumber());
        newAccount.setAmount(0d);
        return newAccount;
    }

    public void printUsers() {
        for (User user : userList.getAll()) {
            System.out.println(user);
        }
    }
}