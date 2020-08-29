package com.example.inMemorySql.Interface.impl;

import com.example.inMemorySql.Interface.Constraint;
import lombok.Data;

@Data
public class MandatoryConstraint implements Constraint {

    @Override
    public boolean checkConstraint(Object value) {
        if (value !=null) {
            return true;
        }
        return false;
    }
}
