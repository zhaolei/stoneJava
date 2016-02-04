package org.stone.model;


public class NewsInfo{

    private String path;

    private Long modificationTime;
    
    private Boolean directory = null;

    public String getPath() {
        return path;
    }

    public Long getModificationTime() {
        return modificationTime;
    }
    
    public Boolean isDirectory() {
        return directory;
    }
    

    public FileInfo(String path, Long modificationTime, Boolean isDir) {
        super();
        this.path = path;
        this.modificationTime = modificationTime;
        this.directory = isDir;
    }
    
    public static FileInfo fromFileStatus(FileStatus fStatus, String parentPath, boolean isDir){
        
        FileInfo fInfo = new FileInfo(parentPath, fStatus.getModificationTime(), isDir);
        return fInfo;
        
    }

}
