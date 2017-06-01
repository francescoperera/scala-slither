package slither.sources


trait Source {
  def _type: SourceType
  def toMap: Map[String,String]
}

trait SourceType
case object S3 extends SourceType
case object Socrata extends SourceType
