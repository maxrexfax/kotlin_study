class UserDataConstr : Human {
    var email = ""
    constructor(firstName: String, lastName: String, email: String, age: Int) : super(firstName, lastName, age) {
        this.email = email
    }

    override fun toString(): String {
        return "$firstName $lastName $email $age"
    }
}