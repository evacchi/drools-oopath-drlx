package org.kie.examples;

import java.lang.annotation.Repeatable;

@Repeatable(OOPaths.class)
public @interface OOPath {
    String value();
}
