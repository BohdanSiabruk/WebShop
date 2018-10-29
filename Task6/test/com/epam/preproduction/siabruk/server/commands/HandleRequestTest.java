package com.epam.preproduction.siabruk.server.commands;

import com.epam.preproduction.siabruk.Main;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.server.constant.Constants;
import com.epam.preproduction.siabruk.server.servers.SimpleTcpServer;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.epam.preproduction.siabruk.service.impl.BicycleServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandleRequestTest {

    @BeforeClass
    public static void setContext() {
        BicycleService bicycleService = mock(BicycleServiceImpl.class);
        Bicycle bicycle = new Bicycle();
        bicycle.setWheelSize(30);
        bicycle.setColor("dark");
        bicycle.setPrice(BigDecimal.valueOf(4552));

        when(bicycleService.getAll()).thenReturn(Main.createListProduct());
        when(bicycleService.getById(1)).thenReturn(bicycle);

        ServerSocket serverTCP;
        Runnable threadTCP = null;
        try {
            serverTCP = new ServerSocket(3000);
            threadTCP = new SimpleTcpServer(serverTCP, bicycleService);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread tcp = new Thread(threadTCP);
        tcp.start();
    }

    @Test
    public void tcpServerReturnCount5() {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);
            String request = "getCount";
            s.getOutputStream().write(request.getBytes());

            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            assertEquals("amount of product:5", data);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tcpServerGetItem1() {
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);
            String request = "getItem?id=1";
            s.getOutputStream().write(request.getBytes());

            byte buf[] = new byte[64 * 1024];
            int r = s.getInputStream().read(buf);
            String data = new String(buf, 0, r);

            assertEquals("id: 1" + Constants.DELIMETR + "price: 4552", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}