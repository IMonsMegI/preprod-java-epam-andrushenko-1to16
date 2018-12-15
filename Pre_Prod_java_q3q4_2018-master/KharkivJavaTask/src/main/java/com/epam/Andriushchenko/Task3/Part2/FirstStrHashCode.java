package com.epam.Andriushchenko.Task3.Part2;

import java.util.Objects;

public class FirstStrHashCode {
    private String str;

    public FirstStrHashCode(String s) {
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
        FirstStrHashCode that = (FirstStrHashCode) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str.length());
    }
}
