/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.sender;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pod.receiver.Receiver;

/**
 *
 * @author Maluco Beleza
 */
public class SenderImpl extends UnicastRemoteObject implements Sender {

    private String addressReceiver = "192.168.0.103";

    public SenderImpl() throws RemoteException {
        super();
    }

    @Override
    public void commandFromClient() throws RemoteException {
        ServerSocket serverSocket = null;
        Socket socket;
        try {
            //criar o servidor de socket
            serverSocket = new ServerSocket();

            //preparar o listener para a porta 8483
            serverSocket.bind(new InetSocketAddress(8483));

            while (true) {
                //aguarda conexão
                socket = serverSocket.accept();

                //enviar msg
                socket.getOutputStream().write("SERVER".getBytes());
                socket.getOutputStream().flush();

                //leitura do stream
                InputStream input = socket.getInputStream();
                byte[] b = new byte[1024];
                input.read(b);

                //gera uma string com o comando
                String comm = new String(b);

                if (comm.length() > 0) {
                    //encaminha comando
                    dispatcher(socket, comm);
                } else {
                    //fechar o stream
                    socket.close();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
           ex.printStackTrace();
        } finally {
            try {
                //fecha o servidor socket - encerra o servidor
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void dispatcher(Socket socket, String command) throws IOException, RemoteException, NotBoundException {
        System.out.println(command);
        String comm[] = command.trim().split(":-:");

        if (comm[0].equals("CADASTRAR")) {
                //chama método cadastrar     
                String reploy = null;
                //do {
                    reploy = lookupReceiver().signup(comm[2], comm[1]);
              //  } while (reploy != null);

                socket.getOutputStream().write(reploy.getBytes());
                socket.getOutputStream().flush();
                System.out.println(comm[2]+" "+reploy);
                socket.close();
        }          
        
        if (comm[0].equals("LOGIN")) {
            //chama método logar
            String reploy = null;
                do {
                    reploy = lookupReceiver().singin(comm[1]);
                } while (reploy != null);

                socket.getOutputStream().write(reploy.getBytes());
                socket.getOutputStream().flush();
                System.out.println(comm[1]+" "+reploy);
                socket.close();
        }
        
        if (comm[0].equals("SUBSCRIBER")) {
            //chama método subscreber
            String reploy = null;
                do {
                    reploy = lookupReceiver().subscriber(comm[1], comm[2]);
                } while (reploy != null);

                socket.getOutputStream().write(reploy.getBytes());
                socket.getOutputStream().flush();
                System.out.println(comm[1]+" "+reploy);
                socket.close();
        }
        if (comm[0].equals("PUBLISHER")) {
            //chama método publisher
            String reploy = null;
                do {
                    reploy = lookupReceiver().signup(comm[2], comm[1]);
                } while (reploy != null);

                socket.getOutputStream().write(reploy.getBytes());
                socket.getOutputStream().flush();
                System.out.println(comm[2]+" "+reploy);
                socket.close();
        }
        if (comm[0].equals("LOGOUT")) {
            //chama o método logout
            String reploy = null;
                do {
                    reploy = lookupReceiver().logout(comm[1]);
                } while (reploy != null);

                socket.getOutputStream().write(reploy.getBytes());
                socket.getOutputStream().flush();
                System.out.println(comm[2]+" "+reploy);
                socket.close();
        }

    }

    @Override
    public void commandToReceiver(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Receiver lookupReceiver() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(this.addressReceiver, 8475);
        Receiver receiver = (Receiver) registry.lookup("Receiver");
        return receiver;
    }

}
