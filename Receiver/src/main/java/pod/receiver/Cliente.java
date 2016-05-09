/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.receiver;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import pod.server.Server;

/**
 *
 * @author NandaPC
 */
public class Cliente {
    
    private Registry registry;
    private Server lockup; 

    public Cliente() throws RemoteException, NotBoundException {
        this.registry = LocateRegistry.getRegistry("localhost", 8080);
        lockup = (Server) registry.lookup("ServerImpl");
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public Server getLockup() {
        return lockup;
    }

    public void setLockup(Server lockup) {
        this.lockup = lockup;
    }
    
    
}
