package com.epam.preproduction.siabruk.server.commands.impl.httpimpl;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.server.Request;
import com.epam.preproduction.siabruk.server.commands.ServerCommand;
import com.epam.preproduction.siabruk.server.constant.Constants;
import com.epam.preproduction.siabruk.server.wrapper.WrapperJson;
import com.epam.preproduction.siabruk.service.BicycleService;

import static java.util.Objects.isNull;

public class GetNameAndPriceCommand implements ServerCommand {
    private BicycleService bicycleService;

    public GetNameAndPriceCommand(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @Override
    public String execute(Request request) {
        int value;
        try {
            value = Integer.parseInt((String) request.getAttribute(Constants.GETCOUNT));
        } catch (NumberFormatException e) {
            return Constants.BAD_REQUEST_RESPONSE_400;
        }

        Bicycle bicycle = bicycleService.getById(value);
        if (isNull(bicycle)) {
            return Constants.NO_SUCH_PRODUCT;
        }
        return WrapperJson.wrappString("id: " + value + Constants.DELIMETR + "price: " + bicycle.getPrice());
    }
}
