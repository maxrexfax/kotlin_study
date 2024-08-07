open class Human(var firstName: String,
            var lastName: String,
            var age: Int)  {
    override fun toString(): String {
        return "$firstName $lastName $age"
    }
}