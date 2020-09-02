package com.wrangling.models;

public abstract class File {
    protected String url;
    protected String extension;

    public File(String url, String extension) {
        this.url = url;
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public String getExtension() {
        return extension;
    }

    public String getFullName() {
        return String.format("%s.%s", url, extension);
    }
}
