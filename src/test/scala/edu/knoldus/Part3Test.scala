package edu.knoldus

import org.scalatest.FunSuite
import java.io.File

class Part3Test extends FunSuite {

  test("testing parse URL method"){
    assert(new Part3().parseUrl("abcd") == "Cannot be Parsed")
  }

  test("testing parse URL method with correct input"){
    assert(new Part3().parseUrl("https://www.google.co.in/?gfe_rd=ce&dss=dc") == "Protocol -> https\nHost -> google\nDomain -> co.in\nQuery Parameter -> Map(gfe_rd -> ce, dss -> dc)\n")
  }

  test("testing read write file method"){
    val file = new File("src/test/url.txt")
    assert(new Part3().readWriteFile(file) == true)

  }
}
