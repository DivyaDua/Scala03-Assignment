package edu.knoldus

import java.io.{File, FileNotFoundException, PrintWriter}
import scala.io.Source

class Part2 extends ReadAndWrite{

  def countingWords(directory: File): List[Boolean] = {

    val files: List[File] = readFilesFromDirectory(directory)

    val newDirectoryName = directory.getAbsolutePath + "_new"
    val newDirectory: File = createDirectory(newDirectoryName)

    if(!files.isEmpty) {
      val booleanList: List[Boolean] = for{file <- files
                                           result = writeOutput(file,newDirectory)
      } yield result
      booleanList
      //files.foreach(writeOutput(_, newDirName))
    }
    else {
      throw new FileNotFoundException
    }
  }

  def writeOutput(sourceFile: File, destinationDir: File): Boolean = {

    //val Word = "\\b([A-Za-z\\-])+\\b".r
    val counter = Source.fromFile(sourceFile)
      .getLines.flatMap(_.split("\\W+"))
      .toList.map(_.toLowerCase)
      .groupBy(identity)
      .mapValues(_.length)

    //println(counter)

    val l:List[String] = counter.toList.map(_._1.toLowerCase)
    val wordsCount = l.length

    val answer = "Number of words : " + wordsCount

    writeFilesToDirectory(sourceFile, destinationDir, answer)
  }

}
