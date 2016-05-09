/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.receiver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NandaPC
 */
public interface Receive extends Remote{

    public String sendServerApp(String msg)throws RemoteException;
    
    public String receiver(String msg)throws RemoteException;
}
