package com.example.inMemorySql.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ColumnCreationRequest {
    String columnName;
    String type;
    int length;
    List<String> constraints;
}
