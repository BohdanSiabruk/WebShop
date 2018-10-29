package com.epam.preproduction.siabruk.server.commands.impl.tcpimpl;

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

        String value = (String) request.getAttribute(Constants.GETCOUNT_TCP);
        Bicycle bicycle = null;
        try {
            bicycle = bicycleService.getById(Integer.valueOf(value));
        } catch (NumberFormatException e) {
            System.out.println(Constants.BAD_REQUEST_RESPONSE_400);
        }

        if (isNull(bicycle) ) {
            return Constants.NO_SUCH_PRODUCT;
        }
        return "id: " + value + Constants.DELIMETR + "price: "  + bicycle.getPrice();
    }
}
