package İsletimProje3;

import java.util.ArrayList;
import java.util.List;


class File {
    private String name;
    private String content;

    public File(String name) {
        this.name = name;
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void writeContent(String content) {
        this.content = content;
    }

    public void appendContent(String content) {
        this.content += content;
    }
}


class Directory {
    private String name;
    private List<File> files;
    private List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addDirectory(Directory directory) {
        subDirectories.add(directory);
    }

    public void removeFile(String fileName) {
        files.removeIf(file -> file.getName().equals(fileName));
    }

    public void removeDirectory(String dirName) {
        subDirectories.removeIf(dir -> dir.getName().equals(dirName));
    }

    public File getFile(String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    public Directory getDirectory(String dirName) {
        for (Directory dir : subDirectories) {
            if (dir.getName().equals(dirName)) {
                return dir;
            }
        }
        return null;
    }
}
