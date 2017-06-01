package slither

import slither.literatetomatoAPI.LiterateTomatoAPI

import scalaj.http.{Http, HttpResponse}


object LiterateTomato {

  def get(callType: LiterateTomatoAPI, dataVector: String) = {
    val response: HttpResponse[String] = Http(callType.url).postData(dataVector).method("POST").headers(Seq(( "Cache-Control", "no-cache"),( "Content-Type","application/json"))).asString
    response.body
  }


}
