package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 * 0. Что такое DI? [#6876]
 * 2. Сканирование проекта [#1070]
 * 3. @Autowired. Внедрение зависимости [#261276]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.04.2023
 */
@Component
public class StartUI {
    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput consoleInput;
    private final String ask = "Введите данные: ";
    private final String quit = "q";

    public void initUI() {
        String run = "";
        while (!quit.equals(run)) {
            run = consoleInput.askStr(ask);
            if (!quit.equals(run)) {
                add(run);
                print();
            }
            System.out.println("Для выхода введите : 'q'");
        }
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
