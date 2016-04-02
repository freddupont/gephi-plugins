/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author fred
 */
public class Config {
    private File mBaseFolder=null;
    private List<File> mFiles=null;
    private HashMap<String, FileNode> mFileNodes=null;
    //private List<FileNode> mFileNodes=null;
    private int mNbOfFiles;
    
    //storing default value
    String[] extensions;
    
    public Config(){
        mNbOfFiles=0;
        extensions = new String[] { "pdf", "PDF" };
        
    }

    /**
     * @return the baseFolder
     */
    public File getBaseFolder() {
        return mBaseFolder;
    }
    
    /**
     * @return the baseFolder String
     */
    public String getBaseFolderString() {
        return mBaseFolder.getAbsolutePath().toString();
    }
    /**
     * @param baseFolder the baseFolder to set
     */
    public void setBaseFolder(File baseFolder) {
        this.mBaseFolder = baseFolder;
        
        //get the whole file liste matching the extension       
        mFiles = (List<File>) FileUtils.listFiles(baseFolder,extensions,true);
        mNbOfFiles=mFiles.size();
    }

    public String getStringFilesList()
    {
        String temp=mFiles.toString();
        temp=temp.substring(1, temp.length()-1);
        System.out.println(temp);
        temp=temp.replace(',','\n');
        System.out.println(temp);
        return temp;
    }
    public void computeFilesNames()
    {
        assert getNbOfFiles()>0;
        
        //beggin the generation of the node list
        mFileNodes=new HashMap<String, FileNode>();
        //for(File file : mFiles){
          //todo parse file name and add node  
        //}
    }
    /**
     * @return the nbOfMatch
     */
    public int getNbOfFiles() {
        return mNbOfFiles;
    }
    
    
    
}
