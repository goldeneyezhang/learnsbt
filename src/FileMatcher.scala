object FileMatcher {
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  private def filesHere = (new java.io.File(".").listFiles())

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}
