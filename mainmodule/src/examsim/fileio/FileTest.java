//package src.examsim.fileio;
//
//import org.junit.Test;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.UUID;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class FileTest {
//
//    @Test
//    public void checkWhetherFileExists() throws IOException {
//        Path path = Paths.get("/Users/mac/Downloads/sampledatafoodsales.xlsx");
//        Path path2 = Paths.get("/Users/mac/Downloads");
//        Path path3 = Paths.get("../premium");
//        Path relativize = path2.relativize(path);
//        System.out.println("relativize: " + relativize.toAbsolutePath());
//        System.out.println(path3.toAbsolutePath());
//        System.out.println(path3.toAbsolutePath());
//        Path path4 = Paths.get("/Users/mac/Downloads/sampledatafoodsales.xlsx");
//        assertTrue(Files.exists(path));
//        assertTrue(Files.isRegularFile(path));
//        assertTrue(Files.isReadable(path));
//        assertTrue(Files.isWritable(path));
//        assertTrue(Files.isExecutable(path3));
//        assertTrue(Files.isSameFile(path, path4));
//    }
//
//    @Test
//    public void givenFilePathWhenCreateNewFileThenCorrect() throws IOException {
//        String filName = "myfile_" + UUID.randomUUID() + ".txt";
//        Path path = Paths.get(filName);
//        assertFalse(Files.exists(path));
//
//        Files.createFile(path);
//        assertTrue(Files.exists(path));
//    }
//}
