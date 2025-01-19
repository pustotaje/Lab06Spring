package ru.arkhipov.MySpringBoot2Dbase.controller;

import lombok.Getter;
@Getter

public class ApiResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}