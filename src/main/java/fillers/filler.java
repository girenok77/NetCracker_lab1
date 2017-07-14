package fillers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author Girenok
 * Annotation for marking methods that generate diffrents non-sorted arrays
 * {@link fillers.Generate}
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface filler {


}
