package org.example.itheimabigevent.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented//元注解
@Target({FIELD})//元注解
@Retention(RUNTIME)//元注解
@Constraint(validatedBy = {})

public @interface State {
    String message() default "state参数的值只能是已发布或者草稿";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
