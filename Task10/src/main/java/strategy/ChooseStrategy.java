package strategy;

import constant.Constants;
import strategy.impl.CookieStrategy;
import strategy.impl.HiddenFieldStrategy;
import strategy.impl.SessionStrategy;

import java.util.HashMap;
import java.util.Map;

public class ChooseStrategy {

    private Map<String, CaptchaStrategy> mapStrategy;

    private String strategyParam;

    public ChooseStrategy(String strategyParam) {

        this.strategyParam = strategyParam;
    }

    public CaptchaStrategy chooseStrategy() {
        createChooseList();
        return mapStrategy.get(strategyParam);
    }

    private void createChooseList() {
        mapStrategy = new HashMap<>();
        mapStrategy.put(Constants.COOCIE_STRATEGY, new CookieStrategy());
        mapStrategy.put(Constants.SESSION_STRATEGY, new SessionStrategy());
        mapStrategy.put(Constants.HIDDEN_STRATEGY, new HiddenFieldStrategy());
    }
}
