package com.college.springgraphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handleStudentNotFoundException(StudentNotFoundException e) {
        return GraphqlErrorBuilder.newError()
                .message(e.getMessage())
                .errorType(ErrorType.DataFetchingException)
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {
        return GraphqlErrorBuilder.newError()
                .message(e.getMessage())
                .errorType(ErrorType.ValidationError)
                .build();
    }
}
