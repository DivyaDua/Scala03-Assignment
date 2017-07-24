package edu.knoldus

import java.io.File
import org.scalatest.FunSuite

class Part2Test extends FunSuite {

 test("testing count words method"){
   val dir: File = new File("src/test/part2test1")
    assert(new Part2().countingWords(dir) == List(true, true))
  }

  test("testing write output method in part 2"){
    val sourceFile = new File("src/test/part1test2/testFile.txt")
    val destDir = new File("src/test/part1test2")

    assert(new Part2().writeOutput(sourceFile, destDir ) == true)

  }

}
