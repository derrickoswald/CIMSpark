package ch.ninecode.cim

import scala.math.atan2

/**
 * Convex hull generator.
 * see https://github.com/caente/convex-hull/blob/master/src/main/scala/com/miguel/GrahamScanScala.scala
 */
object Hull extends Serializable
{
    /**
     * Useful alias for a pair of coordinates.
     */
    type Point = (Double, Double) // lon,lat  or x,y

    /**
     * Determines if p2 lies to the left (counter-clockwise) of the line segment p0-p1.
     *
     * @param p0 line point 1
     * @param p1 line point 2
     * @param p2 point being tested
     * @return <code>true</code> if the angle defined by p0-p1-p2 is a left turn, <code>false</code> if it's a right turn
     */
    def ccw (p0: Point, p1: Point, p2: Point): Boolean =
        (p1._1 - p0._1) * (p2._2 - p0._2) - (p2._1 - p0._1) * (p1._2 - p0._2) > 0.0

    /**
     * Generate the convex hull for the given points.
     *
     * Generates the line string coordinates for an efficient bounding area around the points (shrinkwrap).
     *
     * @param hull  the hull so far
     * @param point the point to be added
     * @return the new hull
     */
    def add (hull: List[Point], point: Point): List[Point] =
    {
        point :: hull.foldRight(List.empty[Point])
        {
            case (p1, rest@(p0 :: _)) =>
                if (ccw(p0, p1, point))
                    p1 :: rest
                else
                    rest
            case (p, list) =>
                p :: list
        }
    }

    /**
     * Perform a Graham Scan to find the convex hull.
     *
     * See https://en.wikipedia.org/wiki/Graham_scan.
     *
     * @param points the points to process.
     * @return the convex hull in a clockwise direction from the lowest left point
     *         Note: the starting point is included at the end as well to form a closed area
     */
    def scan (points: List[Point]): List[Point] =
    {
        // perform a secondary sort by minimum x in case two points have the same minimum y
        val pp = points.sortBy(_._1)
        val min = pp.minBy(_._2)

        def angle (point: Point): Double = atan2(point._2 - min._2, point._1 - min._1)

        min :: pp.sortBy(angle).foldLeft(List.empty[Point])(add)
    }
}