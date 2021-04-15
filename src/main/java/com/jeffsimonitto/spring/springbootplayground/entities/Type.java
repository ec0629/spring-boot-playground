package com.jeffsimonitto.spring.springbootplayground.entities;

public enum Type {
    PLASTIC("PLASTIC"),
    WOOD("WOOD");

    public static final Type[] ALL = { PLASTIC, WOOD };

    private final String name;

    public static Type forName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null for type");
        }
        if (name.equalsIgnoreCase("PLASTIC")) {
            return PLASTIC;
        } else if (name.equalsIgnoreCase("WOOD")) {
            return WOOD;
        }
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
    }

    Type(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
