/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.coordenador;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NandaPC
 */
public class CoordenadorImpl extends UnicastRemoteObject implements Coordenador{

    public CoordenadorImpl() throws RemoteException{
        super();
    }
    
    private Local getTxLocalA() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		Local local = (Local) registry.lookup("localA");
		return local;
    }

    private Local getTxLocalB() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		Local local = (Local) registry.lookup("localB");
		return local;
    }
    
    private Local getTxLocalC() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost", 10989);
		Local local = (Local) registry.lookup("localC");
		return local;
    }
    
    
    @Override
    public void prepareAll() throws RemoteException {
        try {
            
            Local localA = getTxLocalA();
            Local localB = getTxLocalB();
            Local localC = getTxLocalC();
            
            localA.prepare();
            localB.prepare();
            localC.prepare();
            
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void commitAll() throws RemoteException {
    
        try {
            
            Local localA = getTxLocalA();
            Local localB = getTxLocalB();
            Local localC = getTxLocalC();
            
            localA.commit();
            localB.commit();
            localC.commit();
            
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void roolbackAll() throws RemoteException {
    
        try {
            
            Local localA = getTxLocalA();
            Local localB = getTxLocalB();
            Local localC = getTxLocalC();
            
            localA.rollback();
            localB.rollback();
            localC.rollback();
            
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }
    
}
