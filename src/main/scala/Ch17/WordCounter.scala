package Ch17

import scala.collection.mutable

/**
 * Created by sukruhasdemir on 19/01/15.
 */
object WordCounter {
    def main(args: Array[String]): Unit = {
        val text = "See Spot run! Run, Spot. Run!"

        println("Word counts in: \"" + text +"\"")
        println(countWords(text))
    }

    def countWords(s: String): mutable.Map[String, Int] = {
        val splittedArray = s.split("[ !?,.]+").map(_.toLowerCase)

        val wordTuples = splittedArray.map((_, 1)).toList

        val countAccumulator = mutable.Map.empty[String, Int]

        (countAccumulator /: wordTuples) ((map, wTuple) => {
            if (map.keySet.contains(wTuple._1))
                map(wTuple._1) += 1
            else
                map += wTuple

            map
        })

        countAccumulator
    }
}
