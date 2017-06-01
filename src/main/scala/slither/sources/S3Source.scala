package slither.sources


case class S3Source(accessKeyId: String,
                    secretAccessKey: String,
                    region: String,
                    bucket:String,
                    folder:String
                   ) extends Source {
  def toMap: Map[String, String] = Map(
    "accessKeyId" -> accessKeyId,
    "secretAccessKey" -> secretAccessKey,
    "region" -> region,
    "bucket" -> bucket,
    "folder" -> folder
  )
}




