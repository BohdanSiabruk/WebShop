package com.epam.preproduction.siabruk.server.commands;

import com.epam.preproduction.siabruk.server.Request;
import com.epam.preproduction.siabruk.server.commands.container.ServerCommandsContainer;
import com.epam.preproduction.siabruk.server.constant.Constants;
import com.epam.preproduction.siabruk.server.parsehelper.ParseHelper;
import com.epam.preproduction.siabruk.server.wrapper.WrapperJson;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

import static com.epam.preproduction.siabruk.server.constant.Constants.BAD_REQUEST_RESPONSE_400;
import static com.epam.preproduction.siabruk.server.constant.Constants.NOT_FOUND_RESPONSE_404;

public class HandleRequest implements Runnable {
    private Socket socket;
    private BicycleService bicycleService;

    public HandleRequest(Socket socket, BicycleService bicycleService) {
        this.socket = socket;
        this.bicycleService = bicycleService;
    }

    @Override
    public void run() {
        System.out.println("INFO:  Server com.epam.preproduction.siabruk.run()");

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            Request request =createRequest(inputStream);

            if (Objects.isNull(request.getMethodCommand())) {
                outputStream.write(badRequestResponse().getBytes());
            }
            ServerCommand serverCommand = new ServerCommandsContainer(bicycleService).
                    getCommand(request.getMethodCommand());
            String response = serverCommand.execute(request);

            if (Objects.nonNull(response)) {
                outputStream.write(response.getBytes());
            } else {
                outputStream.write(notFountResponse(request.getMethodCommand()).getBytes());
            }
            outputStream.flush();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String badRequestResponse() {
        String response = "HTTP/1.1 400 Bad Request\n";

        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        response = response + "Date: " + df.format(new Date()) + "\n";

        return String.format(BAD_REQUEST_RESPONSE_400, response);

    }

    private String notFountResponse(String path) {
        String response = "HTTP/1.1 404 Not Found\n";

        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        response = response + "Date: " + df.format(new Date()) + "\n";

        response = String.format(NOT_FOUND_RESPONSE_404, response);

        return response;
    }

    private Request createRequest(InputStream inputStream){
        byte buf[] = new byte[65536];
        String readData = null;
        try {
            int readBytes = inputStream.read(buf);
            readData = new String(buf, 0, readBytes);
        } catch (Exception e) {
            System.out.println("index out of bound exception");
        }
       return ParseHelper.parseRequest(readData);
    }
}
