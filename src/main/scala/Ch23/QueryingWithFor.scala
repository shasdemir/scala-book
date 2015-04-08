package Ch23

/**
 * Created by sukruhasdemir on 08/04/15.
 */
object QueryingWithFor {
    case class Book(title: String, authors: String*)

    val books: List[Book] =
        List(
            Book(
                "Structure and Interpretation of Computer Programs",
                "Abelson, Harold", "Sussman, Gerald J."
            ),
            Book(
                "Principles of Compiler Design",
                "Aho, Alfred", "Ullman, Jeffrey"
            ),
            Book(
                "Programming in Modula-2",
                "Wirth, Niklaus"
            ),
            Book(
                "Elements of ML Programming",
                "Ullman, Jeffrey"
            ),
            Book(
                "The Java Language Specification", "Gosling, James",
                "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
            )
        )

    def main(args: Array[String]): Unit = {
        val out1 = for (b <- books; a <- b.authors; if a startsWith "Gosling")
            yield b.title

        val out2 = for (b <- books; if (b.title indexOf "Program") >= 0)
            yield b.title

        val out3 = for (b1 <- books; b2 <- books if b2 != b1;
                        a1 <- b1.authors; a2 <- b2. authors if a2 == a1)
            yield a1

        val out4 = removeDuplicates(out3)

        println(out1)
        println(out2)
        println(out3)
        println(out4)
    }

    def removeDuplicates[A](xs: List[A]): List[A] = {
        if (xs isEmpty) xs
        else
            xs.head :: removeDuplicates(xs.tail.filter(_ != xs.head))
    }

    def removeDuplicates2[A](xs: List[A]): List[A] = {
        xs.head :: removeDuplicates2(
            for (x <- xs.tail if x!= xs.head) yield x
        )
    }
}
