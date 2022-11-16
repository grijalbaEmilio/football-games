package loadFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileManager {

    public List<String> readFileLineByLine(String filePath) throws IOException {

        List<String> fileLineByLine = new ArrayList<>();
        BufferedReader file = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = file.readLine()) != null) {
            fileLineByLine.add(line);
        }

        file.close();

        return  fileLineByLine;
    }

    public String readFile(String filePath) throws IOException {

        StringBuilder fileString = new StringBuilder();
        ArrayList<String> fileLineByLine = (ArrayList<String>) readFileLineByLine(filePath);

        for(String line: fileLineByLine) {
           String newLine = line+"\n";
            fileString.append(newLine );
        }

        return fileString.toString();
    }

    public void writeFile(String fileContentString, String filePath) throws IOException {

        byte[] fileBytes = fileContentString.getBytes();
        Path directoryPath = Paths.get(filePath);

        Files.write(directoryPath, fileBytes);
    }

    public void writeFile(List<String> fileLineByLine, String filePath) throws IOException {

        Path directoryPath = Paths.get(filePath);
        String fileContentString = fileLineByLine
                .stream()
                .reduce("", (y, x) -> {
                   if(fileLineByLine.indexOf(x) == fileLineByLine.size() - 1) return y + x;

                   return y + x + "\n";
                });

        byte[] fileBytes = fileContentString.getBytes();

        Files.write(directoryPath, fileBytes);
    }

}
