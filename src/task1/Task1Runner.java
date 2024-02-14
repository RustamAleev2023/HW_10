package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1Runner {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Map<String, String> phoneNumbers;
        boolean run = true;
        while (run){
            showMenu();
            String action = scanner.nextLine();
            switch (action) {
                case ("0") -> {
                    phoneNumbers = new HashMap<>();
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите фамилию контакта:");
                    String lastname = scanner.nextLine();
                    System.out.println("Введите ник контакта:");
                    String nick = scanner.nextLine();
                    System.out.println("Сколько телефонных номеров Вы хотите добавить?");
                    int count = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < count; i++) {
                        System.out.println("Введите номер телефона в формате (+79111234455)");
                        String phone = scanner.nextLine();
                        System.out.println("Введите тип телефона (домашний, рабочий, мобильный, факс)");
                        String phoneType = scanner.nextLine();
                        phoneNumbers.put(phone, phoneType);
                    }
                    boolean isEmail = true;
                    String email = "";
                    while (isEmail){
                        System.out.println("Введите email");
                        email = scanner.nextLine();
                        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                        Matcher matcher = pattern.matcher(email);
                        if(!matcher.matches()){
                            System.out.println("Неверный формат email");
                        } else {
                            isEmail = false;
                        }
                    }
                    System.out.println("Введите дату рождения");
                    String birthday = scanner.nextLine();
                    phoneBook.addContact(new Contact(name, lastname, nick , phoneNumbers, email, birthday));

                }
                case ("1") -> phoneBook.getAll();
                case ("2") -> {
                    System.out.println("Введите имя контакта");
                    String name = scanner.nextLine();
                    phoneBook.getContactByName(name);
                }
                case ("3") -> {
                    System.out.println("Введите номер телефона в формате (+79111234455)");
                    String phone = scanner.nextLine();
                    phoneBook.getContactByPhone(phone);
                }
                case ("4") -> run = false;
            }
        }

    }

    public static void showMenu(){
        String[] actions = {"Создать новый контакт"
                , "Просмотреть все контакты", "Найти контакт по имени"
                , "Найти контакт по номеру телефона", "Выход"};
        System.out.println("Выберите действие (0 - 4)");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i]);
        }

    }

}
