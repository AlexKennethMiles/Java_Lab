package com.Miles.Lab_27_28;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Class<Worker> workerClass = Worker.class;
        //||\\
        List<Method> methods = Arrays.stream(workerClass.getDeclaredMethods())
                .filter(a -> Arrays.stream(a.getAnnotations())
                .anyMatch(b -> b instanceof TypeOfOperation))
                .collect(Collectors.toList());
        //||\\
        List<ReflectionTask> tasks = worker.getTasks();
        TypeOfOperation operation;
        //||\\
        for (ReflectionTask task : tasks) {
            for (Method method : methods) {
                operation = method.getAnnotation(TypeOfOperation.class);
                if (task.getType().equals(operation.name())) {
                    try {
                        method.invoke(worker, task.getData());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}