package com.task3;

/**
 * Created by user on 29.03.2016.
 */
public class Finded {

    /**
     * ����� �������� �� ����� ������
     */
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i*i <= number; i++)
            if (number % i == 0) return false;
        return true;
    }

    /**
     * ����� ��������� ������ ������� � ����
     */
    public static int bitCounter(int n) {
        int counter = 0;
        while (n != 0) {
            counter += n & 1;
            n = n >>> 1;
        }
        return counter;
    }


    /**
     * ����� ������ ������ ��������� ������ ������� � ����
     */
    public static int bitCounterNew(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * ����� ������ ���������� ����� � ��������� ������� ������ ������� � �������� �������
     */
    public static int findMinPrime(int n){
        int max=0;
        int maxBin=0;

        for (int i = 0; i < n; i++) {

            if (isPrime(i)){

                if (maxBin<=bitCounter(i)){
                    maxBin=bitCounter(i);
                    max=i;
                }

            }

        }
        return max;
    }

}
