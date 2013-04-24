package data

import clientApi.*
import clientApi.Gender.*
import mailApi.Mailer
import clientApi.Status.*

fun client(
        name: String, email: String?,
        gender: Gender = Gender.UNSPECIFIED, isInterestedInSpam: Boolean = true,
        orders: List<Order> = listOf()
): Client {
    return Client(PersonalInfo(name, gender, email), isInterestedInSpam, orders)
}

// products
val cactus = Product("cactus", 11.2)
val cake = Product("cake", 3.2)
val camera = Product("camera", 134.5)
val car = Product("car", 30000.0)
val carrot = Product("carrot", 1.34)
val cellPhone = Product("cell phone", 129.9)
val chimney = Product("chimney", 190.0)
val certificate = Product("certificate", 99.9)
val cigar = Product("cigar", 8.0)
val coffee = Product("coffee", 8.0)
val coffeeMaker = Product("coffee maker", 201.2)
val cola = Product("cola", 4.0)
val cranberry = Product("cranberry", 4.1)
val crocs = Product("crocs", 18.7)
val crocodile = Product("crocodile", 20000.2)
val cushion = Product("cushion", 131.0)

//clients
val bob = client("Bob", "bob@gmail.com", gender = MALE,
        orders = listOf(Order(cake, SUCCESSFUL), Order(cola, SUCCESSFUL), Order(carrot, SUCCESSFUL)))

val ana = client("Ana", "ana@mail.ru", gender = FEMALE,
        orders = listOf(Order(coffee, SUCCESSFUL), Order(cigar, SUCCESSFUL), Order(coffeeMaker, SUCCESSFUL)))

val x = client("X", email = null,
        orders = listOf(Order(cactus, SUCCESSFUL), Order(coffee, SUCCESSFUL), Order(cushion, SUCCESSFUL), Order(camera, SUCCESSFUL),
                Order(cellPhone, SUCCESSFUL), Order(chimney, SUCCESSFUL)))

val fleur = client("Fleur", "fleur@yahoo.com", gender = FEMALE,
        orders = listOf(Order(cranberry, IN_PROCESS), Order(crocs, SUCCESSFUL), Order(certificate, REJECTED)))

val sophie = client("Sophie", "sophie@laposte.net", gender = FEMALE, isInterestedInSpam = false,
        orders = listOf(Order(coffee, SUCCESSFUL), Order(car, IN_PROCESS), Order(crocs, IN_PROCESS)))

val clientData = ClientsData(listOf(bob, ana, x, fleur, sophie),
        setOf(cactus, cake, camera, car, carrot, cellPhone,
                chimney, certificate, cigar, coffee, coffeeMaker,
                cola, cranberry, crocs, crocodile, cushion))
