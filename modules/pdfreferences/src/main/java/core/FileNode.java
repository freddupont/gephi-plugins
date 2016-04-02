/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * design to store the file node data
 * @author fred
 */
public class FileNode {
    public String mParsedName;
    public String mRegexName;
    public String mTitle;
    public String mFileNameInfo;
    public String mSubdDir;
    public List<File> mFiles=null;
    public List<String> mLinks=null;
    public List<String> mFullNames=null;
    public boolean hasMultipleMatch=false;
    
    public boolean isEmpty()
    {
        return mFiles==null;
    }
    

    
    /**
 * constructor with empty node
 * @author fred
 */

    //case of emptynode
    public FileNode(String parsedName,String regexName,String fullName){
        this.mParsedName=parsedName;
        this.mRegexName=regexName;
        this.mFullNames=new ArrayList<String>();
        mFullNames.add(fullName);
    }
    public void addFullName(String fullName)
    {
        mFullNames.add(fullName);
    }
    
    //case of fullnode
    public FileNode(String parsedName,String regexName,String fullName,File file,String title,String fileNameInfo,String subdDir){
        mFiles=new ArrayList<File>();
        mFiles.add(file);
        mLinks=new ArrayList<String>();
        mTitle=title;
        mFileNameInfo=fileNameInfo;
        mSubdDir=subdDir;
        
        this.mParsedName=parsedName;
        this.mRegexName=regexName;
        this.mFullNames=new ArrayList<String>();
        mFullNames.add(fullName);
    }
    
    public void addLink(String link) 
            throws Exception
    {
        if (mLinks==null ) {
            throw new Exception("this node has no links (emptynode)");
        }
        else{
            mLinks.add(link);
        }
    }
    
    public File getFile()
            throws Exception
    {
        if (isEmpty()) {
            throw new Exception("this node has no files (emptynode)");
        }
        else{
            return mFiles.get(0);
        }
    }
    
    public void addFile(File file,String title,String fileNameInfo,String subdDir) 
            throws Exception
    {
        if (isEmpty()) {
            throw new Exception("this node has no files (emptynode)");
        }
        else{
            hasMultipleMatch=true;
            if (file.lastModified()<mFiles.get(0).lastModified())
            {//if the file is older go at the end of the list
                mFiles.add(file);
            }
            else {//if the file is younger it become the new references
                mFiles.add(0,file);
                mTitle=title;
                mFileNameInfo=fileNameInfo;
                mSubdDir=subdDir;
            }
            
        }
    }
}
