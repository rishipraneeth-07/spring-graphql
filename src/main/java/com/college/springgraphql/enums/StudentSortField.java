package com.college.springgraphql.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudentSortField {

    ID("id"),
    NAME("name"),
    AGE("age"),
    EMAIL("email"),
    CGPA("cgpa");

    private final String fieldName;
}