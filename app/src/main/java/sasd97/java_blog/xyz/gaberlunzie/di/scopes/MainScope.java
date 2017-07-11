package sasd97.java_blog.xyz.gaberlunzie.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by alexander on 11/07/2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MainScope {
}
