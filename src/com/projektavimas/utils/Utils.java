package com.projektavimas.utils;

import java.util.Scanner;

public class Utils {

    public static boolean isValidIndex(int offset, int bound) {
        if (offset >= 0) {
            return offset < bound;
        }
        return false;
    }

    public static Scanner getScanner() {
        return  new Scanner(System.in);
    }
}
