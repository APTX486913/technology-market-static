package com.wulianwang.technology_markets.Bean;

public class Download {
    private int id;
    private String download_title;
    private String download_content;
    private String download_link;
    private String release_time;


    public String getDownload_title() {
        return download_title;
    }

    public void setDownload_title(String download_title) {
        this.download_title = download_title;
    }

    public String getDownload_content() {
        return download_content;
    }

    public void setDownload_content(String download_content) {
        this.download_content = download_content;
    }

    public String getDownload_link() {
        return download_link;
    }

    public void setDownload_link(String download_link) {
        this.download_link = download_link;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
