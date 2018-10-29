package com.epam.preproduction.siabruk.server.servers;

import com.epam.preproduction.siabruk.service.BicycleService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class BicycleShop implements Runnable{

    private BicycleService bicycleService;

    @Override
    public void run() {
        initServer();
    }


    public BicycleShop(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    private void initServer(){
        try {
            ServerSocket serverTCP = new ServerSocket(3000);
            Runnable threadTCP = new SimpleTcpServer(serverTCP, bicycleService);
            new Thread(threadTCP).start();

            ServerSocket serverHTTP = new ServerSocket(8080);
            Runnable threadHTTP = new SimpleHttpServer(serverHTTP, bicycleService);
            new Thread(threadHTTP).start();

        } catch (UnknownHostException e) {
            System.err.println("UnknownHostException in com.epam.preproduction.siabruk.servers.BicycleShop#initServer" + e);
        } catch (IOException e) {
            System.err.println("IOException in com.epam.preproduction.siabruk.servers.BicycleShop#initServer" + e);
        }
    }

    public BicycleService getBicycleService() {
        return bicycleService;
    }
}
