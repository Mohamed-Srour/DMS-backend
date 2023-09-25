package com.task.dms.exceptions;

import lombok.Getter;

public class DuplicatedExceptions extends RuntimeException {
    @Getter
    private final int id;

    public DuplicatedExceptions(int id) {
        super();
        this.id = id;
    }
}