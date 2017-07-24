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
    val content = Source.fromFile(sourceFile).getLines.mkString.toLowerCase

    val regex = """[a-zA-Z]+""".r

    val words = for{ s <- regex.findAllIn(content)
    }yield s

    val mapOfWords = words.toList.groupBy(identity).mapValues(_.length).mkString("\n")

    writeFilesToDirectory(sourceFile, destinationDir, mapOfWords)
  }

}
