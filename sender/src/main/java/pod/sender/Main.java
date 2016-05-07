/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.sender;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import pod.receiver.Receiver;

/**
 *
 * @author Maluco Beleza
 */
public class Main {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
  //      Sender send = new SenderImpl();
  //      send.commandFromClient();
  
   Registry registry = LocateRegistry.getRegistry("localhost", 8475);
   Receiver receiver = (Receiver) registry.lookup("Receiver");
   String result = receiver.singin("jederson@gmail.com");
   System.out.println(result);
    
    }
}
