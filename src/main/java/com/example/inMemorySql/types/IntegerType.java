package com.example.inMemorySql.types;


import lombok.Data;

@Data
public class IntegerType implements Type {
    private int maxTypeValue;
    private int minTypeValue;
    private String name;

    public IntegerType(){
        this.maxTypeValue = 1024;
        this.minTypeValue = -1024;
        this.name="String";
    }

    @Override
    public boolean validateType(Object value) {
        if(!(value instanceof Integer))
            return false;
        Integer i = (Integer)value;
        if(i<minTypeValue || i > maxTypeValue)
            return false;
        return true;
    }
}
