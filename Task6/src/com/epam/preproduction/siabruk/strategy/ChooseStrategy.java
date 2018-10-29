package com.epam.preproduction.siabruk.strategy;

import com.epam.preproduction.siabruk.strategy.impl.ConsoleStrategy;
import com.epam.preproduction.siabruk.strategy.impl.GenerateStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChooseStrategy {
    private Map<String, BicycleStrategy> chooseGenerator;
    private static final String GENERATE = "2";
    private static final String CONSOLE = "1";
    private String language;

    public ChooseStrategy(String language) {
        this.language = language;
    }

    public BicycleStrategy chooseStrategy(String strategy) {
        createChooseList();
        return chooseGenerator.get(strategy);
    }

    public Map<String, BicycleStrategy> getChooseGenerator() {
        return chooseGenerator;
    }

    public void createChooseList() {
        chooseGenerator = new LinkedHashMap<>();
        chooseGenerator.put(GENERATE, new GenerateStrategy());
        chooseGenerator.put(CONSOLE, new ConsoleStrategy(language));
    }
}
