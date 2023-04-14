package ru.job4j.di;

import java.util.Scanner;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 * 0. Что такое DI? [#6876]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.04.2023
 */
public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
