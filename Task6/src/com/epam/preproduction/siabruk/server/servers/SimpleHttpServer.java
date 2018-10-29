package com.epam.preproduction.siabruk.server.servers;

import com.epam.preproduction.siabruk.server.Request;
import com.epam.preproduction.siabruk.server.commands.HandleRequest;
import com.epam.preproduction.siabruk.server.commands.ServerCommand;
import com.epam.preproduction.siabruk.server.commands.container.ServerCommandsContainer;
import com.epam.preproduction.siabruk.server.parsehelper.ParseHelper;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer implements Runnable {

    private ServerSocket serverSocket;
    private BicycleService bicycleService;

    public SimpleHttpServer(ServerSocket serverSocket, BicycleService bicycleService) {
        this.serverSocket = serverSocket;
        this.bicycleService = bicycleService;
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Runnable handleRequest = new HandleRequest(socket, bicycleService);
                new Thread(handleRequest).start();
            } catch (IOException e) {
                System.err.println("init error: " + e);
            }
        }
    }
}
