package edu.knoldus

import java.io.File
import org.scalatest.FunSuite

class ReadAndWriteTest extends FunSuite with ReadAndWrite{

  val file1 = new File("src/test/part1test1/testFile1.txt")
  val file2 = new File("src/test/part1test1/testFile.txt")
  val file3 = new File("src/test/part1test1/testFile2.abc")
  val file4 = new File("src/test/part1test1/testFile3.txt")

  val dir = new File("src/test/part1test1")
  val dir1 = new File("src/test/writeTest")
  val dir2 = new File("src/test/createDirTest")

  test("testing read files from directory method"){
    assert(readFilesFromDirectory(dir) == List[File](file4, file1, file2))
  }

  test("testing check extension method"){
    assert(checkExtension(List(file1, file2, file3)) == List(file1, file2))
  }

  test("testing create directory method"){
    assert(createDirectory("src/test/createDirTest") == dir2)
  }

  /*test("testing create directory method for exception"){
    intercept[Exception]{
      createDirectory("src/test/part1test1")
    }
  }
*/
  test("testing write files to directory method"){
    assert(writeFilesToDirectory(file1, dir1, "Hello Divya") == true)
  }


}
