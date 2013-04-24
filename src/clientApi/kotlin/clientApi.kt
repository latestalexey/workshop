package clientApi

/*
Let's imagine we have an online shop with registered clients that can order some products.
We store the information about clients, products and order history for each client.
Also we send newsletters about new products to clients who agreed to receive it.
*/

data class ClientsData(
        val clients: List<Client>,
        val products: Set<Product>
)

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
