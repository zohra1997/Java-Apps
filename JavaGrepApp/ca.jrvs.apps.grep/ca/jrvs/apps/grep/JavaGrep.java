
package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;


public interface JavaGrep {

    void process() throws IOException;
    /*
    Travese a directory and retun a list of all files
    rootDir inout Directory
    @return files under root directory.
     */

    List <File> listFiles (String rootDir);
    /* read a file and return all the lines
     inputfile to be read
     return lines
     should throw and IllegalArgument Exception if inputfile is not a file
     */

    List<String> readLines(File inputFile);

    /* check if the line contains the regex expression

    line is the input
    return true if there is a match

     */

    boolean containsPattern(String line);
    /* write the lines to a file
     throws Io exception

     */

    void writeToFile(List<String> lines) throws IOException;

    String getRootPath();
    void setRootPath(String rootPath);

    String getRegex();
    void setRegex(String regex);
    String getOutFile();
    void setOutFile(String outFile);


}
