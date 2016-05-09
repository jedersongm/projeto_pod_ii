/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NandaPC
 */
public class Main {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(8080);
        registry.bind("ServerImpl", new ServeImpl());
    }
    
}
