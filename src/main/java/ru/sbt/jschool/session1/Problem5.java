package ru.sbt.jschool.session1;

public class Problem5 {
    public long binaryToDec(String binary)
    {
        return (long) Long.parseLong(binary, 2);
    }

    public static void main(String[] args) {
        // На вход подаётся строка, содержащее число в бинарной системе счичсления. Нужно вернуть десятичное число(long) public long binaryToDec(String binary);
        Problem5 test = new Problem5();
        System.out.println(test.binaryToDec(args[0]));
    }
}
