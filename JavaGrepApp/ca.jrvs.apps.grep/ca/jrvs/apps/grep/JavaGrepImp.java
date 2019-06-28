
package ca.jrvs.apps.grep;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class JavaGrepImp implements JavaGrep {

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

        File folder = new File(rootDir);
        List <File> files  = new ArrayList<>();
        for (File f:folder.listFiles()){
             if (f.isDirectory()){

                 files.addAll(listFiles(f.getAbsolutePath()));
             }
             else
                 files.add(f);

        }

        return files;

    }

    @Override
    public List<String> readLines(File inputFile) {
        List<String> Lines = new ArrayList<>();
        try(BufferedReader buffer = new BufferedReader(new FileReader(inputFile))){
            String eachLine;
            while ((eachLine = buffer.readLine())!=null){
                Lines.add(eachLine);

            }


        }
        catch (IOException exception){
            exception.printStackTrace();

        }


        return Lines;
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
