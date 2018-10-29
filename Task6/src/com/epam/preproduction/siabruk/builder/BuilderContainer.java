package com.epam.preproduction.siabruk.builder;

import java.util.LinkedHashMap;
import java.util.Map;

public class BuilderContainer {
    private Map<String, BuilderProduct> typeListOfBuilder;

    public BuilderContainer() {
        this.typeListOfBuilder = new LinkedHashMap<>();
    }

    public void addToBuilderContainer(String key, BuilderProduct builderProduct) {
        typeListOfBuilder.put(key, builderProduct);
    }

    public BuilderProduct getBuilder(String key) {
        BuilderProduct builder = typeListOfBuilder.get(key.toLowerCase());
        if (builder != null) {
            return builder;
        } else {
            throw new IllegalArgumentException("No product");
        }
    }

}
