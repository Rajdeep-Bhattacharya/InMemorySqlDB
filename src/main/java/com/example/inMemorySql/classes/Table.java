package com.example.inMemorySql.classes;

import com.example.inMemorySql.Interface.impl.MandatoryConstraint;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Data
public class Table {
    String name;
    List<Column> columns;
    List<List<Object>> rows;


    public void printAll(){

    }
    public void filter(String columnName,Object val){

    }
    public boolean insert(List<HashMap<String,Object>> listOfInserts) throws Exception {
        List<List<Object>> rows = new ArrayList<>();
        for(HashMap<String,Object> map : listOfInserts) {
            List<Object> row = new ArrayList<>();
            for (int i = 0; i < columns.size(); i++) {
                Object valueToBeInserted = map.getOrDefault(columns.get(i).getName(),null);
                if (!columns.get(i).validateInsertIntoColumn(valueToBeInserted)) {
                    throw new Exception("failed validation for column " + columns.get(i).getName());
                }
                row.add(valueToBeInserted);
            }
            rows.add(row);
        }
        this.rows.addAll(rows);
        return true;
    }



}
