/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.coordenador;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NandaPC
 */
public interface Local extends Remote{

    void prepare() throws RemoteException;
    
    void commit() throws RemoteException;
    
    void rollback() throws RemoteException;
}
