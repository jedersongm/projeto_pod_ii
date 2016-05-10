/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.receiver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author jederson
 */
public class Main {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        //System.setProperty("java.rmi.server.hostname", "192.168.2.10");
        Receiver receiver = new ReceiverImpl();

        Registry registry = LocateRegistry.createRegistry(8475);
        registry.bind("Receiver", receiver);
        System.out.println("Receiver ativo");

        //System.out.println(receiver.signup("Raul Seixas", "raul@gmail.com"));
    }
}
