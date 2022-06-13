package creational.singleton

object SingletonApplication

fun main() {
    val thread = Thread {
        val obj = SingletonApplication
        println(obj.toString())
    }
    val thread2 = Thread {
        val obj2 = SingletonApplication
        println(obj2.toString())
    }

    thread.start()
    thread2.start()
}
