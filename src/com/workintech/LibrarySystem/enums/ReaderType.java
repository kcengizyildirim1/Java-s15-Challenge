package com.workintech.LibrarySystem.enums;

public enum ReaderType {
    STUDENT,
    AKADEMISYEN;
    public static ReaderType fromString(String value) {
        try {
            return valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
