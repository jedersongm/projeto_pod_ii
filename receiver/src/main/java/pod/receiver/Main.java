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
 * @author Maluco Beleza
 */
public class Main {
   
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
          Receiver receiver = new ReceiverImpl();
          
          Registry registry = LocateRegistry.createRegistry(8475);
          registry.bind("Receiver", registry);
          System.out.println("Receiver ativo");
          
          //System.out.println(receiver.signup("Raul Seixas", "raul@gmail.com"));
    }
      
}
