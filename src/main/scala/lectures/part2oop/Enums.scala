package lectures.part2oop

object Enums extends App {
    enum Permissions {
        case READ, WRITE, EXECUTE, NONE

        // add fields/methods
        def openDocument(): Unit = {
            if (this == READ) println("Reading is allowed")
            else println("Reading is not allowed")
        }
    }

    // constructor args
    enum PermissionsWithBits(bits: Int) {
        case READ extends PermissionsWithBits(4)
        case WRITE extends PermissionsWithBits(2)
        case EXECUTE extends PermissionsWithBits(1)
        case NONE extends PermissionsWithBits(0)
    }

    // companion object of enum
    object PermissionsWithBits {
        def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.NONE
    }

    val somePermissions: Permissions = Permissions.READ
    somePermissions.openDocument()

    // standard API
    val somePermissionsOrdinal = somePermissions.ordinal
    val allPermissions = PermissionsWithBits.values
    val readPermissions = Permissions.valueOf("READ")

    println(somePermissionsOrdinal)
    println(allPermissions)
}
