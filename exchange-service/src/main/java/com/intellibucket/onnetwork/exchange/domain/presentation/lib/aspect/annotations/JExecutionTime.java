package com.intellibucket.onnetwork.exchange.domain.presentation.lib.aspect.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface JExecutionTime {
}
