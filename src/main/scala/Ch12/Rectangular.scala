package Ch12

/**
 * Created by sukruhasdemir on 07/01/15.
 */
class Point(val x: Int, val y: Int)

trait Rectangular {
    def topLeft: Point
    def bottomRight: Point

    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
    // and so on
}
