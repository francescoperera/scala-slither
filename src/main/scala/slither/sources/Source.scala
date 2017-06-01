package slither.sources


trait Source {
  def _type: String
  def toMap: Map[String,String]
}

trait SourceType
case object S3 extends SourceType
case object Socrata extends SourceType
