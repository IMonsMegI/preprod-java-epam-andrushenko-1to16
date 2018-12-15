package com.epam.Andriushchenko.Task3.Part2;

import java.util.Objects;

public class SecondStrHashCode {
    private String str;

    public SecondStrHashCode(String s) {
        str = s;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecondStrHashCode that = (SecondStrHashCode) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        int sumOfSumbols = 0;
        for (int i = 0; i < 4; i++) {
            sumOfSumbols += (int) str.charAt(i);
        }
        return Objects.hash(sumOfSumbols);
    }
}
