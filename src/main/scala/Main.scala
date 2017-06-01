import slither.literatetomatoAPI.{AddressSegmentation, ColumnOntology, DateTranslation}
import slither.{Anduin, LiterateTomato}
import slither.sources.{Csv, S3Source}

object Main extends App {
  val dummyS3: S3Source = S3Source("AKIAIG66OKZETK3MWTEA",
    "pRElH3FkJVcRXOlZm3dGczz69hWpW9amLDHyKkk",
    "us-east-1",
    "fp-data",
    "PII/test/test.json"
  )

//  val anduin: Anduin = new Anduin(dummyS3,"xyz")
//  val data = anduin.transform(Csv)
//  println(data)
  val name = Vector("Francesco Perera")
  val output = LiterateTomato.get(ColumnOntology,name)
  val output2 = LiterateTomato.get(AddressSegmentation, Vector("5 West 119th Apartment 2, New York, New York , 10026"))
  val output3 = LiterateTomato.get(DateTranslation,Vector("29th Jan 1993"))
  println(output)
  println(output2)
  println(output3)
}
