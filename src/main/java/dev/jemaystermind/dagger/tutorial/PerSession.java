package dev.jemaystermind.dagger.tutorial;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.*;

@Scope
@Documented
@Retention(RUNTIME)
@interface PerSession {
}
