/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pod.persistence;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.v1.DbxAccountInfo;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import com.dropbox.core.v1.DbxClientV1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author NandaPC
 */
public class PersistenceDropBoxImpl extends UnicastRemoteObject implements PersistenceDropBox{

        private  static  final  String DROP_BOX_APP_KEY =  "z4xnzj8zoybc9q9" ; 
	private  static  final  String DROP_BOX_APP_SECRET = "0j3bmggm21zz8e5" ;
        private String tokenApp = "cF4cn354EFAAAAAAAAAADVmvre_goeAxjyyfTyI36_WpFXpZLtbcypo2eK3uTRcw";
	private DbxClientV1 dbxClient;
        
    public PersistenceDropBoxImpl() throws RemoteException {
        super();
    }

	public DbxClientV1 authDropbox(String dropBoxAppKey, String dropBoxAppSecret)
			throws IOException, DbxException {
		DbxAppInfo dbxAppInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
		DbxRequestConfig dbxRequestConfig = new DbxRequestConfig("JavaDropbox", Locale.getDefault().toString());
		DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(dbxRequestConfig, dbxAppInfo);
		String authorizeUrl = dbxWebAuthNoRedirect.start();
//		System.out.println("1. Authorize: Go to URL and click Allow : "+ authorizeUrl);
//		System.out.println("2. Auth Code: Copy authorization code and input here ");
//		String dropboxAuthCode = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
//		DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
//		String authAccessToken = authFinish.getAccessToken();
		dbxClient = new DbxClientV1(dbxRequestConfig, tokenApp);
		System.out.println("Dropbox Account Name: "
				+ dbxClient.getAccountInfo().displayName);

		return dbxClient;
	}

	/* returns Dropbox size in GB */
//	public long getDropboxSize() throws DbxException {
//		long dropboxSize = 0;
//		DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
//		// in GB :)
//		dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
//		return dropboxSize;
//	}

    /**
     *
     * @param token
     * @param email
     * @param data
     * @param nomeGrupo
     * @param nomeUsu
     * @param mensagem
     * @return
     * @throws DbxException
     * @throws java.rmi.RemoteException
     * @throws IOException
     */
    
        @Override
	public boolean salvar(String token, String email, Date data, String nomeGrupo, List<String> nomeUsu, String mensagem) throws DbxException, RemoteException, IOException {
		File inputFile = new File(token + ".txt");
                inputFile.createNewFile();
                FileWriter fw = new FileWriter(inputFile);
                        fw.write(email);
                        String dataS = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(data);
                        fw.write(dataS);
                        fw.write(nomeGrupo);
                        fw.write("{");
                        for (int i = 0; i < nomeUsu.size(); i++) {
                            if (i == nomeUsu.size() - 1) {
                                fw.write(nomeUsu.get(i) + "");
                            } else {
                            fw.write(nomeUsu.get(i) + ",");
                            }
                        }
                        fw.write("};");
                        fw.write(mensagem);
                fw.close();

		FileInputStream fis = new FileInputStream(inputFile);
		try {
                    DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + token,DbxWriteMode.add(), inputFile.length(), fis);
                    String sharedUrl = dbxClient.createShareableUrl("/" + token);
                    System.out.println("Uploaded: " + uploadedFile.toString() + " URL "+ sharedUrl);
		} finally {
                    fis.close();
		}
                
                return true;
	}

	public void createFolder(String folderName) throws DbxException {
		dbxClient.createFolder("/" + folderName);
	}

//	public void listDropboxFolders(String folderPath) throws DbxException {
//		DbxEntry.WithChildren listing = dbxClient.getMetadataWithChildren(folderPath);
//		System.out.println("Files List:");
//		for (DbxEntry child : listing.children) {
//			System.out.println("	" + child.name + ": " + child.toString());
//		}
//	}
//
//	public void downloadFromDropbox(String fileName) throws DbxException,
//			IOException {
//		FileOutputStream outputStream = new FileOutputStream(fileName);
//		try {
//			DbxEntry.File downloadedFile = dbxClient.getFile("/" + fileName, null, outputStream);
//			System.out.println("Metadata: " + downloadedFile.toString());
//		} finally {
//			outputStream.close();
//		}
//	}

}
