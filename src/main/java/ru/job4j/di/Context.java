package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. Мидл
 * 3.4. SpringТема
 * 3.4.1. DI. Внедрение зависимостей
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 14.04.2023
 */
public class Context {
    private final Map<String, Object> els = new HashMap<>();

    public void reg(Class cl) throws IllegalAccessException {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalAccessException("Class has multiple constructor : " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Count create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
