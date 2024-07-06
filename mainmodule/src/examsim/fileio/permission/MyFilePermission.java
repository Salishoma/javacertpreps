package src.examsim.fileio.permission;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class MyFilePermission {

    public static void main(String[] args) {
        setFilePermission();
    }

    static void setFilePermission() {
        String strW = "/Users/mac/Downloads/sampledatafoodsales.xlsx";
        FilePermission filePermission = new FilePermission("/Users/mac/Downloads/*", "read");
        PermissionCollection permissionCollection = filePermission.newPermissionCollection();
        permissionCollection.add(filePermission);
        permissionCollection.add(new FilePermission(strW, "read"));
        if (permissionCollection.implies(new FilePermission(strW, "write"))) {
            System.out.println("Read, Write permission is granted for the path " + strW );
        } else
            System.out.println("No Read, Write permission is granted for the path  " + strW );

    }
}
