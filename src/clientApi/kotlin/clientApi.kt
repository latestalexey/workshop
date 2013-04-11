package clientApi

data class Client(
        val personalInfo: PersonalInfo?,
        val isInterestedInSpam: Boolean,
        val orders: List<Order>
)

data class PersonalInfo(
        val name: String,
        val gender: Gender,
        val email: String?
)

data class Order(
        val product: Product,
        val status: Status
)

data class Product(
        val description: String,
        val price: Double
)

enum class Gender {
    MALE FEMALE UNSPECIFIED
}

enum class Status {
    SUCCESSFUL REJECTED IN_PROCESS
}

data class ClientData(
        val clients: List<Client>,
        val products: Set<Product>
)