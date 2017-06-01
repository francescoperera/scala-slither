package slither

import com.typesafe.scalalogging.LazyLogging
import io.circe.{Json, JsonObject}
import slither.literatetomatoAPI.LiterateTomatoAPI
import io.circe.syntax._

import scalaj.http.{Http, HttpResponse}


object LiterateTomato extends LazyLogging {

  def get(callType: LiterateTomatoAPI, dataVector: Vector[String]) = {

    val postData: Option[JsonObject] = jsonifyPostData(dataVector)
    postData match {
      case Some(obj) =>
        val stringObj: String = obj.asJson.toString()
        val response: HttpResponse[String] = Http(callType.url).postData(stringObj).method("POST").headers(Seq(( "Cache-Control", "no-cache"),( "Content-Type","application/json"))).asString
        response.body
      case None =>  None
    }
  }

  def jsonifyPostData(dataVector:Vector[String]): Option[JsonObject] = {
    val optJsonData: Option[Vector[Json]] = dataVector.asJson.asArray
    optJsonData match {
      case Some(jsonVec) => Map("data" -> jsonVec).asJson.asObject
      case None =>
        logger.error(s"$dataVector cannot be encoded to Json Array.")
        None
    }
  }



}
