package com.epam.preproduction.siabruk.server.run;

import com.epam.preproduction.siabruk.server.constant.Constants;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SimpleTcpClient extends Thread {

    public static void main(String[] args) {
        while (true) {
            try {
                Socket socket = new Socket(InetAddress.getLocalHost(), 3000);
                SimpleTcpClient simpleTcpClient = new SimpleTcpClient();
                simpleTcpClient.showAvailableRequest();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter choice");
                String request = scanner.nextLine();

                socket.getOutputStream().write(request.getBytes());

                byte buf[] = new byte[65536];
                int r = socket.getInputStream().read(buf);
                String data = new String(buf, 0, r);

                System.out.println(data);

            } catch (Exception e) {
                System.out.println(Constants.BAD_REQUEST_RESPONSE_400);
            }
        }
    }

    private void showAvailableRequest() {
        System.out.println("- getCount");
        System.out.println("- getItem?id=ID");
    }
}

