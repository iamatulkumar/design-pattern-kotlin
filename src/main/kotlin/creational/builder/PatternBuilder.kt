package creational.builder

import java.security.SecureRandom
import java.util.UUID

/**
 USE FULL LINK: https://code-held.com/2021/01/23/dont-use-builder-in-kotlin/
 https://asvid.github.io/kotlin-builder-pattern
 https://www.geeksforgeeks.org/builder-design-pattern/

 ## Intent
 Builder pattern is use for creating complex composite trees because you can program its construction steps to work recursively.
 Builder patterns are particularly useful when objects need to be created dynamically.
 Builder pattern allows you to create different flavors of an object while avoiding constructor pollution.
 Useful when there could be several flavors of an object.

 Note: it is not recommended to use builder patterns in Kotlin because we can get the same feature using default and named arguments.

 Pros:
 1. It provides clear separation between the construction and representation of an object.
 2. It provides better control over construction process.
 3. It supports to change the internal representation of objects.
 2. You can reuse the same construction code when building various representations of products
 3. Single Responsibility Principle. You can isolate complex construction code from the business logic of the product
 4. The Builder Pattern solves a very common problem in the object-oriented programming of how to flexibly
 create an immutable object without writing many constructors

 Cons:
 1. The overall complexity of the code increases since the pattern requires creating multiple new classes.
 2. If you for some reasons want a mutable object
 3. It does create more code (and could introduce more complexity) in the DTO than
 if you had for example contructor arguments and/or setters/getters

 Using simple constructor in JAVA use overloaded

 class User(firstName:String, lastName:String, mobileNumber:Int)

 User user1 = User("Walter" )
 User user2 = User("Walter","White" )
 User user3 = User("Walter","White", 6651212 )

 if mobile number optional
 class User(String firstName,String lastName, Int mobileNumber) {
 if(mobileNumber == null) {
 mobileNumber = 0000000000000
 }
 }
 User user1 = User("Jesse","Pinkman", 7867876) // with mobile number
 User user2 = User("Walter", "White")     //without mobile number
 we need to make getter setter and check for null

 Kotlin imlementation: class User(firstName:String, lastName:String, mobileNumber:Int = -1)

 // Ideal for Kotlin
 data class Customer(
 val id: UUID = UUID.randomUUID(),
 val username: String,
 val auth0Id: String
 )

 data class Customer(
 val id: UUID = UUID.randomUUID(),
 val username: String,
 val auth0Id: String
 )  {
 companion object {
 fun random() =
 Customer(username = RandomStringUtils.randomAlphanumeric(10), auth0Id = RandomStringUtils.randomAlphanumeric(10))
 }
 }
 *
 */

data class Customer(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val auth0Id: String
) {
    class Builder {
        var id: UUID? = null
        var username: String? = null
        var auth0Id: String? = null

        fun id(id: UUID) = apply { this.id = id }
        fun username(username: String) = apply { this.username = username }
        fun auth0Id(auth0Id: String) = apply { this.auth0Id = auth0Id }

        fun build() = Customer(id!!, username!!, auth0Id!!) // SRP (Single-Responsibility Principle), Builder just constructs the objects with all required data, but object can verify if the data is correct

        fun randomBuild() = id(id ?: UUID.randomUUID())
            .username(username ?: randomString(10))
            .auth0Id(auth0Id ?: randomString(10))
            .build()

        fun randomString(len: Int): String {
            val random = SecureRandom()
            val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray()
            return (1..len).map { chars[random.nextInt(chars.size)] }.joinToString("")
        }
    }
}

fun main() {
/*    val customerNLPWhenIdIsUUIDRandomGenerate = Customer.Builder()
                                                .auth0Id("Amita")
                                                .username("Arora")
                                                .build()*/
   /* val customer = Customer.Builder()
        .id(UUID.fromString("26625c0a-d6d3-11ec-9d64-0242ac120002"))
        .auth0Id("Amita")
        .username("Arora")
        .build()*/

/*    val customer2 = Customer.Builder()
        .randomBuild()*/

    println("Simple output")
}
