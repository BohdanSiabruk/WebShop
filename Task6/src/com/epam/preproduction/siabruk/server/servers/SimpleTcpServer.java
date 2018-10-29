package com.epam.preproduction.siabruk.server.servers;

import com.epam.preproduction.siabruk.server.commands.HandleRequest;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTcpServer implements Runnable {
    private ServerSocket serverSocket;
    private BicycleService bicycleService;

    public SimpleTcpServer(ServerSocket serverSocket, BicycleService bicycleService) {
        this.serverSocket = serverSocket;
        this.bicycleService = bicycleService;
    }

    @Override
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
