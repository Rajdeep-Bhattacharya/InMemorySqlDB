package com.example.inMemorySql.Interface;

import com.example.inMemorySql.Interface.impl.MandatoryConstraint;

public class ConstraintFactory {

    public Constraint getConstraintObject(String name){
        switch(name){
            case "mandatory":
                return new MandatoryConstraint();
        }
        return null;
    }
}
