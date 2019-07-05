package ca.jrvs.apps.grep;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class JavaGrepImp implements JavaGrep {
    String reg;
    String outputFile;
    String rootPath;


    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<>();
        for (File file : listFilesStream(getRootPath())) {
            for (String line : readLinesStream(file)) {
                if (containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        File folder = new File(rootDir);
        List<File> files = new ArrayList<>();
        for (File f : folder.listFiles()) {
            if (f.isDirectory()) {
                files.addAll(listFiles(f.getAbsolutePath()));
            } else
                files.add(f);


        }

        return files;

    }

    public List<File> listFilesStream(String rootDir) throws IOException {

        List<File> files = Files.walk(Paths.get(rootDir))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());


        return files;

    }


    @Override
    public List<String> readLines(File inputFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(inputFile))) {
            String eachLine;
            while ((eachLine = buffer.readLine()) != null) {

                lines.add(eachLine);
            }


        } catch (IOException e) {

            e.printStackTrace();
        }
        return lines;
    }

    public List<String> readLinesStream(File inputFile) {
        List<String> lines = new ArrayList<>();

        try {

            lines = Files.lines(inputFile.toPath())
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (UncheckedIOException e) {
            System.out.println("Ignore:" + inputFile.toString());
        }

        return lines;

    }

    @Override
    public boolean containsPattern(String line) {
        String regex = getRegex();
        if (line.contains(regex)) {
            return true;
        } else

            return false;
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(getOutFile()))) {
            for (String s : lines) {

                buffer.write(s + "\n");
            }


        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;


    }

    @Override
    public String getRegex() {
        return reg;
    }

    @Override
    public void setRegex(String regex) {
        reg = regex;


    }

    @Override
    public String getOutFile() {
        return outputFile;
    }

    @Override
    public void setOutFile(String outFile) {
        outputFile = outFile;

    }


    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("USAGE: regex rootPath outFile");
        }
        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile(args[2]);
        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}