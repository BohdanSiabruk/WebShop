package com.epam.preproduction.siabruk.server.commands;

import com.epam.preproduction.siabruk.server.Request;

public interface ServerCommand {

    String execute(Request request);
}
