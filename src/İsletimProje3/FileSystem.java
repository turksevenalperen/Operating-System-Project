package İsletimProje3;

public class FileSystem {
    private Directory root;

    public FileSystem() {
        this.root = new Directory("/");
    }

    public void createFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            dir.addFile(new File(fileName));
            System.out.println("Dosya oluşturuldu: " + fileName);
        } else {
            System.out.println("Geçersiz yol: " + path);
        }
    }

    public void createDirectory(String path, String dirName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            dir.addDirectory(new Directory(dirName));
            System.out.println("Dizin oluşturuldu: " + dirName);
        } else {
            System.out.println("Geçersiz yol: " + path);
        }
    }

    public void writeFile(String path, String fileName, String content) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = dir.getFile(fileName);
            if (file != null) {
                file.writeContent(content);
                System.out.println("Dosyaya yazıldı: " + fileName);
            } else {
                System.out.println("Dosya bulunamadı: " + fileName);
            }
        } else {
            System.out.println("Geçersiz yol: " + path);
        }
    }

    public void readFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            File file = dir.getFile(fileName);
            if (file != null) {
                System.out.println("İçeriği " + fileName + ": " + file.getContent());
            } else {
                System.out.println("Dosya bulunamadı:" + fileName);
            }
        } else {
            System.out.println("Geçersiz yol:" + path);
        }
    }

    public void deleteFile(String path, String fileName) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            dir.removeFile(fileName);
            System.out.println("Dosya silindi: " + fileName);
        } else {
            System.out.println("Geçersiz yol: " + path);
        }
    }

    public void listFiles(String path) {
        Directory dir = navigateToDirectory(path);
        if (dir != null) {
            System.out.println("Dosyaları listeleme" + path + ":");
            for (File file : dir.getFiles()) {
                System.out.println("Dosya: " + file.getName());
            }
            for (Directory subDir : dir.getSubDirectories()) {
                System.out.println("Dizin:" + subDir.getName());
            }
        } else {
            System.out.println("Invalid path: " + path);
        }
    }

    private Directory navigateToDirectory(String path) {
        String[] dirs = path.split("/");
        Directory current = root;
        for (String dirName : dirs) {
            if (!dirName.isEmpty()) {
                Directory nextDir = current.getDirectory(dirName);
                if (nextDir != null) {
                    current = nextDir;
                } else {
                    return null;
                }
            }
        }
        return current;
    }

    public static void main(String[] args) {
       FileSystem vfs = new FileSystem();
        
        vfs.createDirectory("/", "Belgeler");
        vfs.createFile("/Belgeler", "Dosya1.txt");
        vfs.writeFile("/Belgeler", "Dosya1.txt", "Hello, World!");
        vfs.readFile("/Belgeler", "Dosya1.txt");
        vfs.listFiles("/Belgeler");
        vfs.deleteFile("/Belgeler", "Dosya1.txt");
        vfs.listFiles("/Belgeler");
    }
}
