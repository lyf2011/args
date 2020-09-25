package com.thoughtworks.basic;

import java.util.Objects;

public class Arg {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Arg(String key, String value){
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arg that = (Arg) o;
        return key.equals(that.key) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
