package dev.jemaystermind.dagger.tutorial;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.*;

@Qualifier
@Documented
@Retention(RUNTIME)
@interface MaximumWithdrawal {
}
