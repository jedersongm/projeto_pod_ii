/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author NandaPC
 */
public class ServeImpl extends UnicastRemoteObject implements Server{

    public ServeImpl() throws RemoteException {
        super();
    }

    @Override
    public String processMensage(String mensagem) {
            return "" ;   
    }

    
}
