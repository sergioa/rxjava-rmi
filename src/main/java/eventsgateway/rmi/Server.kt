package eventsgateway.rmi

import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject

class Server : UnicastRemoteObject(), RemoteInterface<String> {

    override fun message(): String {
        return "hello world"
    }

    companion object {
        private const val BIND_NAME = "Server"

        private const val PORT = 9999

        @JvmStatic
        fun main(args: Array<String>) {
            System.getSecurityManager()?.let { System.setSecurityManager(SecurityManager()) }

            val registry = LocateRegistry.createRegistry(PORT)

            registry.bind(BIND_NAME, Server())
        }
    }

}
