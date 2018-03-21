package ru.sbt.jschool.session1;

import java.util.Arrays;
import java.util.HashSet;


public class Problem7 {
    public long[] intersection(long[] l1, long[] l2) {

        HashSet<Long> hs = new HashSet<Long>();
        long[] result = new long[l1.length];
        int i = 0;

        for (long l : l1)
            hs.add(l);

        for (long l : l2)
            if (hs.contains(l))
                result[i++] = l;

        result = Arrays.copyOfRange(result, 0,i);
        return result;
    }

    public static void main(String[] args) {
        // На вход методу подаётся два массива long. Вернуть элементы, которые встречаются в обоих массивах public long[] intersection(long[] arr1, long[] arr2);

        long [] a = {1,2,3,4,5};
        long [] b = {3,4,5,6,7};

        Problem7 test = new Problem7();

        long [] c = test.intersection(a,b);

        System.out.println(Arrays.toString(c));
    }
}

