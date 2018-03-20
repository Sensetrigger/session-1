package ru.sbt.jschool.session1;
import java.util.Map;
/**
 */
public class Problem3 {
    public static void main(String[] args) {
        // Написать программу, которая выводит все переменные окружения.
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }


    }
}

