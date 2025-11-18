import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileName = "fisier.txt";

        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe", fileName);
            Process process = pb.start();

            int exitCode = process.waitFor();

            System.out.println("Notepad inchis cu codul: " + exitCode);

            String username = System.getProperty("user.name");
            Path startup = Paths.get(
                    "C:/Users/" + username + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/startText.bat"
            );

            String batContent = "notepad.exe " + fileName;
            Files.write(startup, batContent.getBytes());

            System.out.println("Fișierul va fi deschis automat după restart.");

           // Runtime.getRuntime().exec("shutdown -r -t 0"); //acesta reporneste calculator


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
