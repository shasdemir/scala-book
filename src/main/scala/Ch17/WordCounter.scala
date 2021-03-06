package Ch17

/**
 * Created by sukruhasdemir on 19/01/15.
 */
object WordCounter {
    def main(args: Array[String]): Unit = {
        val text = "See Spot run! Run, Spot. Run!"

        println("Word counts in: \"" + text +"\"")
        println(countWords(text))
    }

    def countWords(s: String): Map[String, Int] = {
        val splitArray = s.split("[ !?,.]+")
        val wordList = splitArray.map(_.toLowerCase).toList

        val countAccumulator = Map.empty[String, Int]
        (countAccumulator /: wordList) ((map, word) => {
            var tempMap = map
            tempMap += (word -> (tempMap.getOrElse(word, 0) + 1))
            tempMap
        })
    }

    def longestWordAndIndex(words: Array[String]) =
        words.zipWithIndex.maxBy(_._1.length)
}
