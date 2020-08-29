package com.example.inMemorySql.types;


import lombok.Data;

@Data
public class StringType implements Type {

    int maxTypeLength;
    String name;
    public StringType(){
        this.maxTypeLength = 20;
        this.name="String";
    }
    public boolean validateType(Object value){
        if(!(value instanceof String))
            return false;
        String s = (String)value;
        if(s.length() > maxTypeLength)
            return false;
        return true;
    }

}
