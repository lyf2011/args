package com.thoughtworks.basic;

import java.util.List;
import java.util.Set;

public class Schema {
    private List<FlagSchema> flagsSchemas;

    public Schema(List<FlagSchema> flagsSchemas) {

        this.flagsSchemas = flagsSchemas;
    }

    public Object getTypeOf(String flag) {
        return flagsSchemas.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }

    public List<FlagSchema> getFlagsSchemas() {
        return flagsSchemas;
    }
}
