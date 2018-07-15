package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume resume = new Resume();
//        Field field = r.getClass().getDeclaredFields()[0];
//        field.setAccessible(true);
//        System.out.println(field.getName());
//        System.out.println(field.get(r));
//       // field.set(r, "new_uuid");
        System.out.println(resume);

        Method method = resume.getClass().getDeclaredMethod("toString");
        method.setAccessible(true);
        System.out.println(method.invoke(resume, null));
    }
}