package creational

data class Person(
    val firstName: String,
    val lastName: String,
    val address: Address,
    val contact: Contact,
    val height: Float? = null,
    val shoeSize: Float? = null,
) {
    init {
        height?.let { require(0f < it) { "height is always greater than 0" } }
        shoeSize?.let { require(4f <= it) { "smallest standard shoe size is 4" } }
    }
}

data class Address(
    val country: String,
    val cityName: String,
    val streetName: String,
    val streetNumber: String,
    val postalCode: String,
    val district: String? = null,
)

data class Contact(
    val workPhoneNumber: String,
    val workEmail: String,
    val privatePhoneNumber: String? = null,
    val privateEmail: String? = null,
) {
    init {
        require(workPhoneNumber.isValidPhoneNumber())
        require(workEmail.isValidEmail())
        require(privatePhoneNumber?.isValidPhoneNumber() ?: true)
        require(privateEmail?.isValidEmail() ?: true)
    }
}

private fun String.isValidEmail(): Boolean {
    return this.isNotEmpty()
}

private fun String.isValidPhoneNumber(): Boolean {
   return this.isNotEmpty()
}

fun main() {
    val person = Person(
        firstName = "Adam",
        lastName = "Świderski",
        address = Address(
            cityName = "Poznań",
            streetName = "ul. Półwiejska",
            streetNumber = "123/1",
            country = "Poland",
            postalCode = "60-000"
        ),
        contact = Contact(
            workEmail = "adam@work.email",
            workPhoneNumber = "123112312",
            privateEmail = "adam@private.email",
            privatePhoneNumber = "2345678"
        ),
        height = 6f,
        shoeSize = 6f,
    )

    println(person)
}
