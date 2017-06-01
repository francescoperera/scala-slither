package slither

import slither.literatetomatoAPI.LiterateTomatoAPI

import scalaj.http.{Http, HttpResponse}


object LiterateTomato {

  def get(callType: LiterateTomatoAPI, dataVector: Vector[String]) = {
    val response: HttpResponse[String] = Http(callType.url).postData("").method("POST").header("Content-Type","application/json").asString
    response.body
  }


}
