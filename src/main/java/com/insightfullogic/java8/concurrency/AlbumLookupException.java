package com.insightfullogic.java8.concurrency;

public class AlbumLookupException extends RuntimeException {

    public AlbumLookupException(Throwable cause) {
        super(cause);
    }

    public AlbumLookupException(String message) {
        super(message);
    }

}
