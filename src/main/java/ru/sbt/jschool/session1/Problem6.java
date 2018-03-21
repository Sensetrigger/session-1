package ru.sbt.jschool.session1;

public class Problem6 {
    public long sumOfBinary(String b1, String b2)
    {
        return (long) Long.parseLong(b1, 2) + (long) Long.parseLong(b2, 2);
    }

    public static void main(String[] args) {
        // На вход подаются 2 строки, содержащие двоичные числа - вернуть строку, содержащую сумму этих чисел в двоичной системе счисления. public long sumOfBinary(String b1, String b2);
        Problem6 test = new Problem6();
        System.out.println(test.sumOfBinary(args[0], args[1]));
    }


}
