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
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
        private String token = "cF4cn354EFAAAAAAAAAAC46genKRazMGH7c-K2IVCrFJxxZ-pk4hvdUSNwrj_8mK";
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
		System.out.println("1. Authorize: Go to URL and click Allow : "+ authorizeUrl);
		System.out.println("2. Auth Code: Copy authorization code and input here ");
		String dropboxAuthCode = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
		DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
		String authAccessToken = authFinish.getAccessToken();
		dbxClient = new DbxClientV1(dbxRequestConfig, authAccessToken);
		System.out.println("Dropbox Account Name: "
				+ dbxClient.getAccountInfo().displayName);

		return dbxClient;
	}

	/* returns Dropbox size in GB */
	public long getDropboxSize() throws DbxException {
		long dropboxSize = 0;
		DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
		// in GB :)
		dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
		return dropboxSize;
	}

	public void uploadToDropbox(String fileName) throws DbxException,
			IOException {
		File inputFile = new File(fileName);
		FileInputStream fis = new FileInputStream(inputFile);
		try {
			DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + fileName,DbxWriteMode.add(), inputFile.length(), fis);
			String sharedUrl = dbxClient.createShareableUrl("/" + fileName);
			System.out.println("Uploaded: " + uploadedFile.toString() + " URL "+ sharedUrl);
		} finally {
			fis.close();
		}
	}

	public void createFolder(String folderName) throws DbxException {
		dbxClient.createFolder("/" + folderName);
	}

	public void listDropboxFolders(String folderPath) throws DbxException {
		DbxEntry.WithChildren listing = dbxClient.getMetadataWithChildren(folderPath);
		System.out.println("Files List:");
		for (DbxEntry child : listing.children) {
			System.out.println("	" + child.name + ": " + child.toString());
		}
	}

	public void downloadFromDropbox(String fileName) throws DbxException,
			IOException {
		FileOutputStream outputStream = new FileOutputStream(fileName);
		try {
			DbxEntry.File downloadedFile = dbxClient.getFile("/" + fileName, null, outputStream);
			System.out.println("Metadata: " + downloadedFile.toString());
		} finally {
			outputStream.close();
		}
	}

	
    @Override
    public boolean salvar(String token, String email, Date data, String nomeGrupo, List<String> nomeUsu, String mensagem) {
        return true;
    }
    
    
}
