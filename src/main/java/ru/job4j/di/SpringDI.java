package ru.job4j.di;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 * 1. Spring DI. Запуск [#2091]
 *
 * @author Dmitry Stepanov, user Dima_Nout
 * @since 15.04.2023
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.initUI();
        ui.print();
    }
}
