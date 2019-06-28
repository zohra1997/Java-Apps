package ca.jrvs.apps.grep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaGrepImpStream implements JavaGrep {

    String reg;
    String RootPath;
    String outputFile;

    @Override
    public void process() throws IOException {

        List<String> matchedLines = new ArrayList<>();

        for (File file: listFiles(getRootPath())){
            for (String line: readLines(file)){
                if(containsPattern(line)){
                    matchedLines.add(line);
                }
            }


        }
        writeToFile(matchedLines);


    }
    @Override
    public List<File> listFiles(String rootDir) {




        return null;
    }

    @Override
    public List<String> readLines(File inputFile) {
        return null;
    }

    @Override
    public boolean containsPattern(String line) {
        String regex = getRegex();
        if (line.contains(regex))
            return true;
        else
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
        return RootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        RootPath= rootPath;


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
        outputFile=outFile;


    }


    public static void main(String[] args) {
        if (args.length !=3){

            throw new IllegalArgumentException("USAGE: regex rootpath outputFile");

        }

        JavaGrepImp javagrepImp = new JavaGrepImp();
        javagrepImp.setRegex(args[0]);
        javagrepImp.setRootPath(args[1]);
        javagrepImp.setOutFile(args[2]);

        try {

            javagrepImp.process();

        } catch (Exception e){

            e.printStackTrace();
        }

    }
}
