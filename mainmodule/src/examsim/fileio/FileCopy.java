package src.examsim.fileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopy {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("file1.txt");
        System.out.println("Path: " + path1);
        boolean exists = Files.exists(path1);
        System.out.println("File exist: " + exists);
//        Files.createFile(path1);
        exists = Files.exists(path1);

        System.out.println("File exist: " + exists);
        System.out.println("Path1: " + path1.toAbsolutePath());
        System.out.println("Content in file1: " + Files.readString(path1));

        Path path2 = Paths.get("file2.txt");
        Path copy = Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Content in file2: " + Files.readString(path2));
        System.out.println("copy: " + copy);

        System.out.println("path1 and path2 are same file: " + (Files.isSameFile(path1, path2)));
        System.out.println("path2 and copy are same file: " + (Files.isSameFile(path2, copy)));

        Path path = Paths.get("/Users", "mac", "Downloads", "file3.txt");
        System.out.println(path.toAbsolutePath());

        Path copy1 = Files.copy(path1, path, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Path: " + path);
        System.out.println(Files.exists(path));
        System.out.println(Files.isSameFile(path, copy1));

    }
}
