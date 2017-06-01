import slither.Anduin
import slither.sources.{CSV, S3Source}

object Main extends App {
  val dummyS3: S3Source = S3Source("AKIAIG66OKZETK3MWTEA",
    "pRElH3FkJVcRXOlZm3dGczz69hWpW9amLDHyKkk",
    "us-east-1",
    "fp-data",
    "PII/test/test.json"
  )

  val anduin: Anduin = new Anduin(dummyS3,"xyz")
  val data = anduin.transform(CSV)
  println(data)
}
