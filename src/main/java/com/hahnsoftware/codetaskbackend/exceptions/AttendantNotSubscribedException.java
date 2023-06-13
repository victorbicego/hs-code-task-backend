package com.hahnsoftware.codetaskbackend.exceptions;

public class AttendantNotSubscribedException extends Exception {

    private static final long serialVersionUID = -531747144799828138L;

    public AttendantNotSubscribedException(String message) {
        super(message);
    }
}
