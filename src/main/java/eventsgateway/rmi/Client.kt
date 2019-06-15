package eventsgateway.rmi


import org.slf4j.LoggerFactory
import java.rmi.Naming

class Client private constructor() {

    companion object {

        private val log = LoggerFactory.getLogger(Client::class.java.name)

        @JvmStatic
        @Suppress("UNCHECKED_CAST")
        fun main(args: Array<String>) {
            val remote = Naming.lookup("//localhost:9999/Server") as? RemoteInterface<String>

            log.info(remote?.message())
        }
    }
}
