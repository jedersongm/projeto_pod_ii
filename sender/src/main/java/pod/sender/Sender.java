/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.sender;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Maluco Beleza
 */
public interface Sender  extends Remote{
    
    void commandFromClient() throws RemoteException;
    
   void  commandToReceiver(String message) throws RemoteException;
    
}
