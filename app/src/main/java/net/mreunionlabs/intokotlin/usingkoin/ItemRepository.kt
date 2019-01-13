package net.mreunionlabs.intokotlin.usingkoin

interface ItemRepository {
    fun getHello(): String
}

class ItemRepositoryImpl() : ItemRepository {
    override fun getHello(): String {
        return "Hello"
    }

}