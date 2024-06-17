package com.intellibucket.lib.payload.event.abstracts;

public interface DomainEvent<T> {
    default void fire(){}
}