package ru.job4j.di;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 * 0. Что такое DI? [#6876]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.04.2023
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.initUI();
        ui.print();
    }
}
