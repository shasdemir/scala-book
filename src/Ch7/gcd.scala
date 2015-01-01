def gcd(x: Long, y: Long):Long =
    if (x == 0) y else gcd(y % x, x)

println("GCD of 3 and 7: " + gcd(3, 7))
println("GCD of 21 and 14: " + gcd(21, 14))
println("GCD of 16 and 1024: " + gcd(16, 1024))
println("GCD of 336 and 786: " + gcd(336, 786))