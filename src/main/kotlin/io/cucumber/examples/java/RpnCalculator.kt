package io.cucumber.examples.java

import java.util.*

class RpnCalculator {
    private val stack: Deque<Number> = LinkedList()
    fun push(arg: Any?) {
        if (OPS.contains(arg)) {
            val y = stack.removeLast()
            val x = if (stack.isEmpty()) 0 else stack.removeLast()
            var `val`: Double? = null
            if (arg == "-") {
                `val` = x.toDouble() - y.toDouble()
            } else if (arg == "+") {
                `val` = x.toDouble() + y.toDouble()
            } else if (arg == "*") {
                `val` = x.toDouble() * y.toDouble()
            } else if (arg == "/") {
                `val` = x.toDouble() / y.toDouble()
            }
            push(`val`)
        } else {
            stack.add(arg as Number)
        }
    }

    fun PI() {
        push(Math.PI)
    }

    fun value(): Number? {
        return stack.last
    }

    companion object {
        private val OPS = Arrays.asList("-", "+", "*", "/")
    }
}