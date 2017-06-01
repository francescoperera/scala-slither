package slither.sources


trait Source {
  def toMap: Map[String,String]
}
