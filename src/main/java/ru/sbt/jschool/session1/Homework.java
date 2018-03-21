package ru.sbt.jschool.session1;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Homework implements PropertyHelper {

    String [] args;
    String path;

    public Homework(String[] a, String p) {
        args = a;
        path = p;
    }

    public Homework() {
        super();
    }

    public String stringValue(String name) {
        return name;
    };

    public Integer integerValue(String name) {
        return Integer.parseInt(name);
    };

    public Double doubleValue(String name) {
        return Double.parseDouble(name);
    };

    public static void main(String[] args) {
        //  Если передан аргумент командной строки вида `name=XXX`, то возвращается он.
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.substring(0, 5).equals("name=") && arg.length() < 9) {
                    try {
                        Integer num = Integer.parseInt(arg.substring(5, arg.length()));
                        System.out.println(num);
                    } catch (NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                }
                break;
            }
        }

        //  Если существует системная настройка вида `name=XXX`, то возвращается её значение.
        else if (System.getProperties().containsKey("name")) {
            Integer num = Integer.parseInt(System.getProperty("name"));
            System.out.println(num);
        }

        //  Если определена переменная окружения вида `name=XXX`, то используется она.
        else if (System.getenv().containsKey("name")) {
            Integer num2 = Integer.parseInt(System.getenv("name"));
            System.out.println(num2);
        }

        else System.out.println("null");
    }
}

