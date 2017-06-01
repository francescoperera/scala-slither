package slither


import sources.Source
import sources.Format

import scalaj.http.{Http,HttpResponse}


class Anduin( source: Source, transformation: Any) {
  //TODO: give type to transformation

  private val URL: String = "http://localhost:8081/stream"

  // for now let it return the body as string, but it will be a a list of NDJSON objects
  def transform( format: Format): String = {
    //TODO: wrap this call in a Try and log the http failure
    val response: HttpResponse[String] = Http(URL).postData(buildPostData(source.toMap)).method("POST").header("Content-Type","application/json;charset=utf-8").asString
    response.body
  }

  // return the JSON body in String format
  def buildPostData(sourceMap: Map[String,String]): String = {
    val rawData: String = s"""
                            {
                                  "source":${sourceMap.toString} ,
                                  "pipelines": [
                                  {
                                    "target": {
                                      "_type": "DirectResponse",
                                      "format": "Csv"
                                    },
                                    "transformations":[],
                                    "pipelines": []
                                  }
                                  ]
                                }
                          """
    rawData

  }

  // save transform output back to s3 at defined destination
  def saveToS3 = ???

  // save transform output to a local file, use Java.nio
  def writeToFile = ???

  // given that transform output is Json, then transform that to an RDD
  def toRDD = ???

  // put transform output in Spark DF
  def toDF = ???

  /** perhaps make also LiterateTomato  do a toRDD , toDF . If so create a trait called Data and
    * define these methods there and implement them in both LiterateTomato and Anduin.
    *
    */

}
