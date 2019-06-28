---


---

<h2 id="introduction">Introduction</h2>
<p>This App searches for a text pattern recursively in a given directory, and output matched lines to a file. The app takes three arguments.</p>
<h2 id="design">Design</h2>
<ul>
<li>GrepApp : is an interface where all the necessary methods have been declared.</li>
<li>GrepAppImp: is a the class taht includes the main method and implements GrepApp interface.<br>
GrepAppImp class implemets list all files of a directory including the subdirectories in two different ways. First is  by recrusively calling the same function and second using java 8 lambda syntax.<br>
read all Lines functions has also been implemented in two ways. First, using buffreredReader and FileReaders and the second methos using java 8 stream and Lambda syntax.</li>
</ul>
<h2 id="usage">Usage</h2>
<pre><code> How To Use:  regex rootPath outFile

 Similar to : egrep -r {regex} {rootpath} &gt; {outFile}
</code></pre>
<ul>
<li>regex:  a string of characters for describing the search pattern</li>
<li>rootpath: path of the directory</li>
<li>outFuile: path to output file and the anme of file</li>
</ul>
<h2 id="improvements">Improvements</h2>
<ol>
<li>Add a feature where every line will be returned with the path of its file to make finding the file easy.</li>
</ol>

