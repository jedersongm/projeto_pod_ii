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
public interface Coordenador extends Remote{

    void prepareAll() throws RemoteException;
    void commitAll() throws RemoteException;
    void roolbackAll() throws RemoteException;
    
    
}
