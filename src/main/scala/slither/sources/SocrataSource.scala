package slither.sources

/**
  * Created by francescoperera on 5/31/17.
  */
case class SocrataSource(domain: String, token: String) {
  def toMap: Map[String, String] = Map( "domain" -> domain, "token" -> token)

}
