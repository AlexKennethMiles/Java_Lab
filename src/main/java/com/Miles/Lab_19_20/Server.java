package com.Miles.Lab_19_20;

import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("===The server is running===");
        byte[] buf = new byte[2048];
        ArrayList<InetAddress> addresses = new ArrayList<>();
        ArrayList<Integer> ports = new ArrayList<>();
        DatagramSocket socket = new DatagramSocket(9123);
        DatagramPacket packet = new DatagramPacket(
                buf,
                0,
                buf.length);
        PrintWriter printer = new PrintWriter("G:/IntelliJ IDEA/MainFolder/Java_Lab/history.txt");
        System.out.println("Chat of " + socket.getLocalPort() + " port" + "\n");

        Thread server = new Thread(() -> {
            while (true) {
                DatagramPacket packetToChat = null;
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Address: " + packet.getAddress());
                System.out.println("Port: " + packet.getPort());
                int flag = 0;
                for (int i = 0; i < ports.size(); i++) {
                    if (ports.get(i) == packet.getPort() && addresses.get(i) == packet.getAddress()) {
                        flag++;
                    }
                }
                if (flag == 0) {
                    addresses.add(packet.getAddress());
                    ports.add(packet.getPort());
                    String welcome = "!!! Welcome " + (new String(buf, 0, packet.getLength())) + " to the server !!!";
                    String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                    String data = date + " | " + welcome;
                    System.out.println(data + "\n");
                    for (int i = 0; i < ports.size(); i++) {
                        try {
                            packetToChat = new DatagramPacket(
                                    data.getBytes(),
                                    0, data.getBytes().length,
                                    InetAddress.getByName("255.255.255.255"), ports.get(i)
                            );
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.send(packetToChat);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    printer.write(data + "\n");
                } else {
                    String message = new String(buf, 0, packet.getLength());
                    String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                    String data = date + " | " + message;
                    System.out.println(data + "\n");
                    for (int i = 0; i < ports.size(); i++) {
                        if (!(packet.getAddress() == addresses.get(i) && packet.getPort() == ports.get(i))) {
                            try {
                                packetToChat = new DatagramPacket(
                                        data.getBytes(),
                                        0, data.getBytes().length,
                                        InetAddress.getByName("255.255.255.255"), ports.get(i)
                                );
                            } catch (UnknownHostException e) {
                                e.printStackTrace();
                            }
                            try {
                                socket.send(packetToChat);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    printer.write(data + "\n");
                }
                printer.flush();
            }
        });
        server.start();
    }
}