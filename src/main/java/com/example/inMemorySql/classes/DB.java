package com.example.inMemorySql.classes;

import com.example.inMemorySql.Interface.Constraint;
import com.example.inMemorySql.Interface.ConstraintFactory;
import com.example.inMemorySql.Interface.impl.MandatoryConstraint;
import com.example.inMemorySql.requests.ColumnCreationRequest;
import com.example.inMemorySql.types.IntegerType;
import com.example.inMemorySql.types.StringType;
import com.example.inMemorySql.types.Type;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
public class DB {

    HashMap<String, Table> db = new HashMap<>();


    public boolean createTable(String tableName, List<ColumnCreationRequest> columnCreationList) throws Exception {
        Table t = new Table();
        t.setName(tableName);
        List<Column> list = new ArrayList<>();
        for (ColumnCreationRequest column : columnCreationList) {
            Column c = Column.builder().name(column.getColumnName()).build();
            Type type = null;
            if (column.getType().equalsIgnoreCase("string"))
                type = new StringType();
            else if (column.getType().equalsIgnoreCase("int"))
                type = new IntegerType();
            if (type == null)
                throw new Exception("invalid type");
            c.setColumnType(type);
            List<Constraint> listOfConstraints = new ArrayList<>();
            ConstraintFactory factory = new ConstraintFactory();
            if(column.getConstraints() != null) {
                for (String constraintName : column.getConstraints()) {
                    Constraint constraint = factory.getConstraintObject(constraintName);
                    if (constraint != null)
                        listOfConstraints.add(constraint);
                }
            }
            c.setConstraintList(listOfConstraints);
            list.add(c);
        }
        t.setColumns(list);
        db.put(tableName,t);
        return true;
    }

}
