/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import com.dropbox.core.DbxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public class main {
//    public static void main(String[] args) {
//        PersistenceTxt p = new PersistenceTxtImpl();
//        List<String> users = new ArrayList<>();
//        users.add("Jederson");
//        users.add("Raul");
//        users.add("Paula Toller");
//        //p.salvarTxt("pod", "fernanda", "fernanda@mail", new Date(), "grupo x",users , "Toca Raul!!!");
//        p.removeTxt("x01z37.txt");
//        //p.lerArquivo();
//    }
    
     private  static  final  String DROP_BOX_APP_KEY =  "z4xnzj8zoybc9q9"; 
     private  static  final  String DROP_BOX_APP_SECRET = "0j3bmggm21zz8e5" ;
     
    public static void main(String[] args) throws IOException, DbxException {
        
        List<String> users = new ArrayList<>();
        users.add("Jederson");
        users.add("Raul");
        users.add("Paula Toller");
	PersistenceDropBoxImpl persistenceDropBoxImpl = new PersistenceDropBoxImpl();
	persistenceDropBoxImpl.authDropbox(DROP_BOX_APP_KEY, DROP_BOX_APP_SECRET);
//	System.out.println("Dropbox Size: " + persistenceDropBoxImpl.getDropboxSize()
//				+ " GB");
	persistenceDropBoxImpl.salvar("pod", "fernanda", new Date(), "Grupo POD", users, "Sistemas ditribidos");
	persistenceDropBoxImpl.createFolder("Projeto");
//	persistenceDropBoxImpl.listDropboxFolders("/");
//	persistenceDropBoxImpl.downloadFromDropbox("happy.png");

	}    

}
