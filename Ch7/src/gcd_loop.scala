/**
 * Created by sukruhasdemir on 30/12/14.
 */

def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y

    while (a != 0) {
        val temp = a
        a = b % a
        b = temp
    }
    b
}