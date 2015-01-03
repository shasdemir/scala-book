package Ch10

class Cat {
    val dangerous = false
}


class Tiger(
           override val dangerous: Boolean,
           private var age: Int
) extends Cat