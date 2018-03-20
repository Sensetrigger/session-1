package ru.sbt.jschool.session1;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Problem4 {
    public static void main(String[] args) {
        //  Написать программу, которая выводит \"Hello, World!\" количество раз переданное:

        //  Если передан параметр вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.contains("JSCHOOL1_COUNT")) {
                    try {
                        Integer num = Integer.parseInt(arg.substring(15));

                        for (int i = 0; i < num; i++)
                            System.out.println("Hello world!");
                    } catch (NumberFormatException e)
                    {
                        e.printStackTrace();
                    }

                }
                break; //JSCHOOL1_COUNT=3
            }
        }

        //  Если передана системная настройка вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
        if (System.getProperties().containsKey("JSCHOOL1_COUNT")) {
            Integer num = Integer.parseInt(System.getProperties().getProperty("JSCHOOL1_COUNT"));
            for (int i = 0; i < num; i++)
                System.out.println("Hello world!");
            System.out.println();
        }

        //  Если определена переменная окружения вида JSCHOOl1_COUNT=XXX, где XXX число раз, то используется оно.
        if (System.getenv().containsKey("JSCHOOL1_COUNT")) {
            Integer num2 = Integer.parseInt(System.getenv().get("JSCHOOL1_COUNT"));
            for (int i = 0; i < num2; i++)
                System.out.println("Hello world!");
            System.out.println();
        }

        //  Если определена переменная окружения вида JSCHOOL1_PROPERTIES_FILE=XXX, где XXX это путь к существующему файлу, то загружаем настройки оттуда и пытаемся получить настройку оттуда.
        if (System.getenv().containsKey("JSCHOOL1_PROPERTIES_FILE")) {
            Properties prop = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(System.getenv().get("JSCHOOL1_PROPERTIES_FILE"));
                prop.load(input);
                System.out.println(prop.getProperty("JSCHOOL1_COUNT"));
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        else System.out.println("Варианты использования программы:");
    }
}
