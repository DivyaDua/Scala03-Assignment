package edu.knoldus

import java.io.{File, FileNotFoundException}
import scala.io.Source

class Part1 extends ReadAndWrite{

  def uppercaseTask(directory: File): List[Boolean] = {

    val files: List[File] = readFilesFromDirectory(directory)

    val newDirectoryName = directory.getAbsolutePath + "_new"
    val destDirectory: File = createDirectory(newDirectoryName)

    if(!files.isEmpty) {
      val booleanList: List[Boolean] = for{file <- files
        result = writeOutput(file,destDirectory)
      } yield result
      booleanList
      //files.foreach(writeOutput(_, newDirName))
    }
    else {
      throw new FileNotFoundException
    }
  }

  def writeOutput(source: File, destinationDir: File): Boolean = {

    val boolean: Boolean = writeFilesToDirectory(source, destinationDir, Source.fromFile(source).getLines.mkString("\n").toUpperCase)
    boolean
  }

}