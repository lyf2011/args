package com.thoughtworks.basic;

import java.util.Objects;

public class FlagSchema {
    private final String flag;
    private final Object valueType;
    private final Object defaultValue;


    public Object getDefaultValue() {
        return defaultValue;
    }
    public Object getValueType() {
        return valueType;
    }
    @Override
    public String toString() {
        return "FlagSchema{" +
                "flag='" + flag + '\'' +
                ", value=" + valueType +
                ", type='" + defaultValue + '\'' +
                '}';
    }

    public String getFlag() {
        return flag;
    }

    public FlagSchema(String flag, Object type, Object defaultValue) {

        this.flag = flag;
        this.valueType = type;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlagSchema that = (FlagSchema) o;
//        System.out.println(flag.trim().equals(that.flag.trim()));
//        System.out.println(valueType.equals(that.valueType));
//        System.out.println(defaultValue.equals(that.defaultValue));
        return flag.equals(that.flag) &&
                valueType.equals(that.valueType) &&
                defaultValue.equals(that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, valueType, defaultValue);
    }

    public boolean equalsWith(String flag) {
        return flag.equalsIgnoreCase(this.flag);
    }

    public Object getType() {
        return this.valueType;
    }
}
