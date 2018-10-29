package com.epam.preproduction.siabruk.server.commands.impl.tcpimpl;

import com.epam.preproduction.siabruk.server.Request;
import com.epam.preproduction.siabruk.server.commands.ServerCommand;
import com.epam.preproduction.siabruk.server.wrapper.WrapperJson;
import com.epam.preproduction.siabruk.service.BicycleService;

public class GetCountCommand implements ServerCommand {
    private BicycleService bicycleService;

    public GetCountCommand(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @Override
    public String execute(Request request) {
        return "amount of product:" + String.valueOf(bicycleService.getAll().size());
    }
}
