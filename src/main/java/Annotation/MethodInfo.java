package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation that stores metadata about a method.
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {

    // Author name with a default value.
    String author() default "Narayan";

    // Date is mandatory when applying the annotation.
    String date();

    // Revision number with a default value.
    int revision() default 1;

    // Additional comments about the method.
    String comments();
}
