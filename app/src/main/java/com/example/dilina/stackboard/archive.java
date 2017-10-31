package com.example.dilina.stackboard;

/**
 * Created by Dilina on 28-Oct-17.
 */

public class archive {

    private String archiveId;
    private String name;
    private String author;
    private String timestamp;

    public archive(){

    }

    public archive(String archiveId, String name, String author, String timestamp) {
        this.archiveId = archiveId;
        this.name = name;
        this.author = author;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(String archiveId) {
        this.archiveId = archiveId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
