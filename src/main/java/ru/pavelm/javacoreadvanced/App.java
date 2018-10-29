package ru.pavelm.javacoreadvanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
// Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
// 3. Необходимо из консоли считать пароль и проверить валидность,
//результат будет true или false
//
//Требования:
//1. Пароль должен быть не менее 8ми символов.
//2. В пароле должно быть число
//3. В пароле должна быть хотя бы 1 строчная буква
//4. В пароле должна быть хотя бы 1 заглавная буква

public class App
{
    public static void main( String[] args )
    {
        task1();
        task2();
        task3();
    }

    //task 1
    public static void task1 () {
        //создаем список слов
        ArrayList<String> listFood = new ArrayList<>();
        listFood.add("cheese");
        listFood.add("milk");
        listFood.add("bread");
        listFood.add("meat");
        listFood.add("chicken");
        listFood.add("sausage");
        listFood.add("apple");
        listFood.add("plum");
        listFood.add("pear");
        listFood.add("grapes");
        listFood.add("grapes");
        listFood.add("pie");
        listFood.add("sweets");
        listFood.add("apple");
        listFood.add("cheese");
        listFood.add("meat");

        //Создаем список повторяющихся слов и уникальных
        HashSet<String> repeated = new HashSet<>();
        HashSet<String> unique = new HashSet<>();
        int n;
        for (int i = 0; i < listFood.size(); i++) {
            n = 0;
            for (String a : listFood) {
                if (listFood.get(i).equalsIgnoreCase(a)) {
                    n++;
                }
            }
            if (n > 1) {
                repeated.add(listFood.get(i));
            } else {
                unique.add(listFood.get(i));
            }
        }

        //Удаляем из listFood повторения
        ArrayList<String> repeatedList = new ArrayList<>(repeated);

        for (int i = 0; i < repeatedList.size(); i++) {
            Iterator<String> iterator = listFood.iterator();
            while (iterator.hasNext()) {
               if (iterator.next().equalsIgnoreCase(repeatedList.get(i))) {
                   iterator.remove();
               }
            }
        }

        System.out.println("Unique word quantity : " + unique.size() + " " + unique);
        System.out.println("Repeated word quantity : " + repeated.size() + " " + repeated);
        System.out.println("Unique word quantity in ArrayList listFood: " + listFood.size() + listFood);
    }

    //task 2
    public static void task2 () {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addNumber("Ivanov", 5745682);
        phoneBook.addNumber("Petrov", 6407129);
        phoneBook.addNumber("Sidorov", 1805473);
        phoneBook.addNumber("Sidorov", 3469122);
        phoneBook.addNumber("Sidorov", 9992475);

        System.out.println(phoneBook.getPhoneBook().toString());
        System.out.println("Number of Sidorov: " + phoneBook.getNumber("Sidorov"));
    }

    //task 3
    public static void task3 () {
        System.out.println("Введите пароль");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);

        System.out.println(matcher.matches());
    }
}