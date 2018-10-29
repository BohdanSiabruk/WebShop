package com.epam.preproduction.siabruk.server.commands.impl;

import com.epam.preproduction.siabruk.server.Request;
import com.epam.preproduction.siabruk.server.commands.ServerCommand;
import com.epam.preproduction.siabruk.server.constant.Constants;
import com.epam.preproduction.siabruk.service.BicycleService;

public class NoSuchServerCommand implements ServerCommand {

    @Override
    public String execute(Request request) {
        return Constants.NO_SUCH_COMMAND;
    }
}
