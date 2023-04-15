package ru.job4j.di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 * 0. Что такое DI? [#6876]
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.04.2023
 */
@Component
public class Store {
    private final List<String> data = new ArrayList<>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
