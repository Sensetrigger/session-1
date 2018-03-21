package ru.sbt.jschool.session1;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Homework implements PropertyHelper {

    String [] args;
    String path;
    Properties prop;

    public Homework(String[] a, String p) {
        args = a;
        path = p;

        if (path != null) {
            Properties pr = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(path);
                pr.load(input);
                prop = pr;
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
    }

    public Homework() {
        super();
    }

    public String stringValue(String name) {
        //  Если передан аргумент командной строки вида `name=XXX`, то возвращается он.
        if (args.length > 0)
            for (String arg : args) {
                if (arg.substring(0, name.length()).equals(name))
                    return arg.substring(arg.indexOf("=") + 1, arg.length());
            }

        //  Если существует системная настройка вида `name=XXX`, то возвращается её значение.
        if (System.getProperties().containsKey(name))
            return System.getProperty(name);

        //  Если определена переменная окружения вида `name=XXX`, то используется она.
        if (System.getenv().containsKey(name))
            return System.getenv(name);

        if (path != null)
            return prop.getProperty(name);

        return null;
    }

    public Integer integerValue(String name) {
        return Integer.parseInt(this.stringValue(name));
    };

    public Double doubleValue(String name) {
        return Double.parseDouble(this.stringValue(name));
    };

    public static void main(String[] args) {
        Homework h = new Homework(args,"config.properties");
        System.out.println(h.stringValue("name"));
    }
}