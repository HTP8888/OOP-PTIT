import java.util.*;

class NotJavaFileException extends Exception {
    public NotJavaFileException(String message) {
        super(message);
    }
}

class File {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public int checkFileExtension() throws NotJavaFileException {
        if (fileName == null || fileName.isEmpty()) {
            throw new NotJavaFileException("Not java file exception. Mark is -1");
        }
        if (fileName.endsWith(".java")) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class EXCEPTION002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while(t-- > 0) {
            String fileName = sc.nextLine();
            File file = new File(fileName);

            try {
                int result = file.checkFileExtension();
                System.out.println(result);
            } catch (NotJavaFileException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}