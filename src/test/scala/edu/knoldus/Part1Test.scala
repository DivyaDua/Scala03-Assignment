package edu.knoldus

import org.scalatest.FunSuite
import java.io.File

class Part1Test extends FunSuite {

  test("testing upper case method"){
    val dir: File = new File("src/test/part1test1")
    assert(new Part1().uppercaseTask(dir) == List(true, true))
  }

  test("testing write output method"){
    val sourceFile = new File("src/test/part1test1/testFile1.txt")
    val destDir = new File("src/test/part1test2")

    assert(new Part1().writeOutput(sourceFile,destDir) == true)

  }
}
