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
 * @author jederson
 */
public interface Receiver extends Remote{
    
     public String signup(String nome, String email)  throws RemoteException;
    
    public String singin(String email) throws RemoteException;
    
    public String subscriber(String email, String grupo) throws RemoteException;
    
    public String publisher(String email, String grupo, String message) throws RemoteException;
    
    public String logout(String email) throws RemoteException;
    
    
}
