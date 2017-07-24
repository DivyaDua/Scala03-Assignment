package edu.knoldus

import java.io.{File, FileNotFoundException, PrintWriter}

import scala.io.Source

object parsingURL{
  def unapply(url: String): Option[(String, String, String, Map[String, String])] = {


    val protocolPart = url.split("://")

    if(protocolPart.length == 1) {
      None
    }
    else {
      val protocol = protocolPart(0)
      val hostDomainPart = protocolPart(1).split("/")

      val hostDomain = hostDomainPart(0).split('.')
      val host = hostDomain(1)

      //val hostDomainPartReverse = hostDomain.reverse.takeWhile(_ == host).rev

      val domain = hostDomain.reverse.takeWhile(_ != host).reverse.mkString(".")

      val queryPart = hostDomainPart(1).split("\\?")(1)
      val queryArray = queryPart.split("&")

      val arr = for {a <- queryArray
                     a1 = a.split("=")(0)
                     a2 = a.split("=")(1)
      } yield (a1, a2)

      val query = arr.toList.toMap

      Some(protocol,host,domain,query)
    }
  }

}

class Part3 extends ReadAndWrite{

  def parseUrl(url : String): String = {

    url match{
      case parsingURL(protocol, host, domain, query) => "Protocol -> " + protocol + "\nHost -> " +
        host + "\nDomain -> " + domain + "\nQuery Parameter -> " + query + "\n"
      case _ => "Cannot be Parsed"
    }
  }

  def readWriteFile(sourceFile: File): Boolean ={

    try {
      val list: List[File] = checkExtension(List(sourceFile))



      if (list.isEmpty) {
        throw new FileNotFoundException("File is not readable")
      }
      else {
        val file = list(0)
        val fileContent = Source.fromFile(file).getLines.mkString("\n")

        val fileContentArray: Array[String] = fileContent.split("\n")
        val fileOutput: Array[String] = for {line <- fileContentArray
                                             output = parseUrl(line)
        } yield output

        //writing to new file
        new PrintWriter("src/test/Output_" + file.getName) {
          write(fileOutput.mkString)
          close
        }
        true
      }
    }
      catch {
        case e: Exception =>false
      }
    }


}


