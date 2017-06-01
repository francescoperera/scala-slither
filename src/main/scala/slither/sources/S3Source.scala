package slither.sources


case class S3Source(accessKeyId: String,
                    secretAccessKey: String,
                    region: String,
                    bucket:String,
                    folder:String
                   ){
  def toMap: Map[String, String] = Map(
    "accessKeyId" -> accessKeyId,
    "secretAccessKey" -> secretAccessKey,
    "region" -> region,
    "bucket" -> bucket,
    "folder" -> folder
  )
}




