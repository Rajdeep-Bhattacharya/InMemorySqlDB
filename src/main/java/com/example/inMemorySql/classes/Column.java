package com.example.inMemorySql.classes;

import com.example.inMemorySql.Interface.Constraint;
import com.example.inMemorySql.types.StringType;
import com.example.inMemorySql.types.Type;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Column {
    String name;
    Type columnType;
    //int length;
    List<Constraint> constraintList;

    public boolean validateInsertIntoColumn(Object value){
        boolean res = true;

        for(Constraint c : constraintList){
            res =res && c.checkConstraint(value);
        }
        return res && columnType.validateType(value);

    }

}
