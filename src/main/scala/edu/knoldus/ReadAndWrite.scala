package edu.knoldus

import java.io.{File, PrintWriter}

trait ReadAndWrite {

  def readFilesFromDirectory(dir: File): List[File] = {

    val list = dir.listFiles.toList
    val selectedFiles = checkExtension(list)
    selectedFiles
  }

  def writeFilesToDirectory(sourceFile: File, destinationDir: File, output: String) = {

    try{
    new PrintWriter(destinationDir.getAbsoluteFile + "/" + sourceFile.getName) {
      write(output)
      close
     }
      true
    }
    catch {
      case e: Exception => false
    }
  }


  def checkExtension(list: List[File]): List[File] = {
    val extensions = List(".txt", ".logs", ".scala")
    val selectedFilesList: List[File] = extensions.flatMap(e => list.filter(_.getName.endsWith(e)))
    selectedFilesList
  }

  def createDirectory(dirName: String): File= {
    val dir: File = new File(dirName)
    dir.mkdir
    dir
  }

}
