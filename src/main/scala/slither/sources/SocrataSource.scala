package slither.sources


case class SocrataSource(domain: String, token: String) extends Source{
  def toMap: Map[String, String] = Map( "domain" -> domain, "token" -> token)

}
