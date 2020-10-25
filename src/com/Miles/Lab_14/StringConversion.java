package com.Miles.Lab_14;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConversion {
    public static void main(String[] args) {
        ArrayList<String> ruleList = new ArrayList<>();
        String rule, word1, word2;
        int N;

        Scanner cin = new Scanner(System.in);
        N = cin.nextInt(); // nextInt считывает только число, в то время как мы ввели строку, на конце которой "\n"
        cin.nextLine(); // этим шагом съедаем символ "\n" из nextInt

        for (int i = 0; i < N; i++) {
            rule = cin.nextLine();
            ruleList.add(rule);
        }

        // разводим на два, чтобы работать по отдельности
        word1 = cin.nextLine();
        word2 = word1;

        // Для применения правил мы будем использовать ruleList
        // соответственно, нам непоходима переменная, которая отвечает за индекс правила
        // удобнее идти "сверху в низ" по "стэку" списка правил, для этого создаем переменную ruleNum
        int ruleNum = N - 1; // буффеная перемменная для удобства перебора правил
        for (int i = 0; i < N; i++) {
            Pattern pattern = Pattern.compile("(\\w+) (\\w+)"); // в pattern передаем форму из двух групп с полным словом каждая, разделенных пробелом
            Matcher m = pattern.matcher(ruleList.get(ruleNum)); // записываем в matcher правило-связку, начиная с последнего в списке
            if (m.matches()) { // если matcher нашел искомый элемент, то производим замену
                word1 = word1.replace(m.group(1), m.group(2)); // в group(1) лежит элемент, который надо заменить на group(2)
                ruleNum--; // движение вниз по "стэку" правил
            }
        }
        System.out.println("String Conversion with RegEx: " + word1);

        //чтобы снова протись по "стэку" правил
        ruleNum = N - 1; // обновляем буффеную перемменную в стоковое состояние
        for (int i = 0; i < N; i++) {
            // В лоб смотрим слово и если нашли по текущему ruleNum правилу претендента на замену, то заменяем
            // В каждом правиле слова разнесены пробелом, сейчас мы оформим разделение для метода replace,
            // работая с каждая "ячейкой" "стэка" правил при помощи метода split
            word2 = word2.replace(ruleList.get(ruleNum).split(" ")[0], ruleList.get(ruleNum).split(" ")[1]);
            ruleNum--; // движение вниз по "стэку" правил
        }
        System.out.println("String Conversion without RegEx: " + word2);
    }
}
