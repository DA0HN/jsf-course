package com.sales.services;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author daohn
 * @since 21/06/2021
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, TYPE, PARAMETER})
public @interface SessionQualifier {
}
