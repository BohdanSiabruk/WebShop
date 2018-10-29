package com.epam.preproduction.siabruk.server.commands.container;

import com.epam.preproduction.siabruk.server.commands.ServerCommand;
import com.epam.preproduction.siabruk.server.commands.impl.NoSuchServerCommand;
import com.epam.preproduction.siabruk.server.commands.impl.httpimpl.GetCountCommand;
import com.epam.preproduction.siabruk.server.commands.impl.httpimpl.GetNameAndPriceCommand;
import com.epam.preproduction.siabruk.server.constant.Constants;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.util.Map;
import java.util.TreeMap;

public class ServerCommandsContainer {
    private Map<String, ServerCommand> commandsList = new TreeMap<>();

    public ServerCommandsContainer(BicycleService bicycleService) {

        commandsList.put(Constants.GET_COUNT_TCP, new com.epam.preproduction.siabruk.server.commands.impl.tcpimpl.GetCountCommand(bicycleService));
        commandsList.put(Constants.GET_NAME_AND_PRICE_TCP, new com.epam.preproduction.siabruk.server.commands.impl.tcpimpl.GetNameAndPriceCommand(bicycleService));

        commandsList.put(Constants.GET_COUNT_HTTP, new GetCountCommand(bicycleService));
        commandsList.put(Constants.GET_NAME_AND_PRICE_HTTP, new GetNameAndPriceCommand(bicycleService));

        commandsList.put(Constants.NO_SUCH_COMMAND, new NoSuchServerCommand());
    }


    public ServerCommand getCommand(String key) {
        if (commandsList.containsKey(key)) {
            System.out.println(commandsList.get(key));
            return commandsList.get(key);
        }
        return commandsList.get(Constants.NO_SUCH_COMMAND);
    }

}
