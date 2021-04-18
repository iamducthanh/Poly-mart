package com.polymart.model;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class UpdatePhotoProduct {

    private List<String> nameFiles;
    private List<File> dstFiles;
    private List<Path> pathFromsFile;

    public List<String> getNameFiles() {
        return nameFiles;
    }

    public void setNameFiles(List<String> nameFiles) {
        this.nameFiles = nameFiles;
    }

    public List<File> getDstFiles() {
        return dstFiles;
    }

    public void setDstFiles(List<File> dstFiles) {
        this.dstFiles = dstFiles;
    }

    public List<Path> getPathFromsFile() {
        return pathFromsFile;
    }

    public void setPathFromsFile(List<Path> pathFromsFile) {
        this.pathFromsFile = pathFromsFile;
    }
}
