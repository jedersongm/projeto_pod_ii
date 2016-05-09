/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.server;

import java.rmi.Remote;

/**
 *
 * @author NandaPC
 */
public interface Server extends Remote{

    public String processMensage(String mensagem);
}
