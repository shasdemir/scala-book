var assertionEnabled = true

def myAssert(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
        throw new AssertionError

myAssert(5 > 3)