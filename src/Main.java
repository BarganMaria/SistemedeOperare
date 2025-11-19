import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Main {
public static void main(String[] args) {
String fileName = "fisier.txt";

try {

    ProcessBuilder pb = new ProcessBuilder("notepad.exe", fileName);
    Process notepadProcess = pb.start();

    int exitCode = notepadProcess.waitFor();
    System.out.println("Notepad inchis cu codul: " + exitCode);


    String username = System.getProperty("user.name");
    Path startup = Paths.get(
    "C:/Users/" + username + "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/startText.bat"
    );

    String batContent = "notepad.exe " + fileName;
    Files.write(startup, batContent.getBytes());
    System.out.println("Fișierul va fi deschis automat după restart.");


    ProcessBuilder browserPb = new ProcessBuilder(
    "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
    "https://else.fcim.utm.md",
    "https://www.google.com",
    "https://www.github.com",
);
Process browserProcess = browserPb.start();

System.out.println("Browser deschis. Va fi inchis automat dupa 10 minute.");


boolean finished = browserProcess.waitFor(10, TimeUnit.MINUTES);

if (!finished) {

    browserProcess.destroy();
    System.out.println("Browser inchis automat dupa 10 minute.");
} else {
    System.out.println("Browser inchis de utilizator inainte de 10 minute.");
}

    //reporneste calculator
    // Runtime.getRuntime().exec("shutdown -r -t 0");

    } catch (IOException | InterruptedException e) {
    e.printStackTrace();
}
}
}