package slither.literatetomatoAPI


trait LiterateTomatoAPI {
  def url: String
}

case object ColumnOntology extends LiterateTomatoAPI {
  def url: String = "http://pii-detector-dev.us-east-1.elasticbeanstalk.com/batch-label"
}
case object AddressSegmentation extends LiterateTomatoAPI {
  def url: String = "http://address-segmentation-dev.us-east-1.elasticbeanstalk.com/address-segment"
}
case object DateTranslation extends  LiterateTomatoAPI {
  def url: String = "http://date-translation-dev.us-east-1.elasticbeanstalk.com/date-translate"
}
