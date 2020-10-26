package server

import java.rmi.Naming
import java.rmi.registry.LocateRegistry
import java.util.*

fun main() {
    try {
        val scanner = Scanner(System.`in`)
        print("Enter your name: ")
        val name = scanner.nextLine().trim()

        LocateRegistry.createRegistry(1099)
        val server = IServerImpl(name)
        val url = "rmi://localhost/rmi_chat"
        Naming.rebind(url, server)

        while (!false) {
            val msg = scanner.nextLine().trim()
            val msg2 = "[${server.name}]: $msg"
            server.broadcastMessage(msg2)
        }
    } catch (e: Exception) {
        error(e)
    }
}
