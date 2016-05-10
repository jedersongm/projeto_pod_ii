/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.receiver;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Maluco Beleza
 */
public class ReceiverImpl extends UnicastRemoteObject implements Receiver{
    
    public ReceiverImpl() throws RemoteException{
        super();
    }
    
    @Override
    public String signup(String nome, String email) throws RemoteException {
        System.out.println("Nome:"+nome+" cadastrou-se com email "+email);               
        return "Cadastrado com sucesso!";
    }

    @Override
    public String singin(String email) throws RemoteException {
        System.out.println("Email "+email+" logou-se");
        return "Logado com sucesso!";
    }

    @Override
    public String subscriber(String email, String grupo) throws RemoteException {
        System.out.println("O usuario  " + email+ " escreveu-se no grupo: "+grupo);
        return "yes";
    }

    @Override
    public String publisher(String email, String grupo, String message) throws RemoteException {
         System.out.println("O usuario  " + email+ " publicou no grupo: "+grupo+"\n");
         System.out.println("Message: "+message);
        return "yes";
    }

    @Override
    public String logout(String email) throws RemoteException {
        System.out.println("Email "+email+" deslogou-se");
        return "yes";
    }
        
    
    
}