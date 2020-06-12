package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var digit = n
    do {
        if (n > 0) {
            digit /= 10
            count++
        } else count = 1
    } while (digit > 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
//    if (n in 1..2) 1
//    else fib(n - 1) + fib(n - 2)
    var fib1 = 1
    var fib2 = 1
    var fibSum = 1
    for (i in 3..n) {
        fibSum = fib1 + fib2
        fib1 = fib2
        fib2 = fibSum
    }
    return fibSum
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    if (m == n) return m
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b) a %= b else b %= a
    }
    return m * n / (a + b)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    if (n % 2 == 0) return 2 else
        for (i in 3..n step 2) {
            if (n % i == 0) return i
        }
    return 0
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    if (n % 2 != 0) {
        for (i in n / 3 downTo 1) if (n % i == 0) return i
    } else return n / 2
    return 0
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b) a %= b else b %= a
    }
    if (a + b == 1) return true
    return false
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (k in m..n) {
        if (sqrt(k.toDouble()) - sqrt(k.toDouble()).toInt().toDouble() == 0.0) return true
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var count = 0
    var numberX = x
    while (numberX != 1) {
        if (numberX % 2 == 0) numberX /= 2 else numberX = numberX * 3 + 1
        count++
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var y = x
    if (x >= 2 * PI) {
        y = x / PI
        y = x / y
    }
    var n = 0
    var a = y
    var b = 0.0
    while (abs(a) > eps) {
        a = (-1.0).pow(n) * y.pow(2 * n + 1) / factorial(2 * n + 1)
        b += a
        n += 1
    }
    return b
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var y = x
    if (x >= 2 * PI) {
        y = x / PI
        y = x / y
    }
    var n = 1
    var a = y
    var b = 0.0
    while (abs(a) > eps) {
        a = (-1.0).pow(n) * y.pow(2 * n) / factorial(2 * n)
        b += a
        n += 1
    }
    if (x >= 2 * PI) b = (b + 1) * (-1) else b += 1
    return b
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    if (n == 0) return n
    if (n / 10 == 0) return n
    var a = n
    var ost: Int
    var sum = 0
    do {
        ost = a % 10
        a /= 10
        sum = sum * 10 + ost
    } while (a > 0)
    return sum
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var number = n
    var count = 0
    var digit: Int
    var revert = 0
    if (n in 0..9) return true
    while (number > 0) {
        number /= 10
        count++
    }
    number = n
    if (count % 2 == 0) count /= 2 else count = (count - 1) / 2
    for (i in 0 until count) {
        digit = number % 10
        revert = revert * 10 + digit
        number /= 10
    }
    when (revert) {
        number -> return true
        number / 10 -> return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n in 0..9) return false
    var number = n
    var digit: Int
    val digitRef = n % 10
    while (number > 0) {
        digit = number % 10
        number /= 10
        if (digit == digitRef) continue else return true
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var length = 0
    var number = 0
    var sqrNumber = 0
    var count: Int
    while (length < n) {
        number++
        sqrNumber = sqr(number)
        count = digitNumber(sqrNumber)
        length += count
    }
    return sqrNumber / (10.0.pow(length - n)).toInt() % 10
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var length = 0
    var count: Int
    var digit = 0
    while (length < n) {
        digit++
        count = digitNumber(fib(digit))
        length += count
    }
    return fib(digit) / (10.0.pow(length - n)).toInt() % 10
}
