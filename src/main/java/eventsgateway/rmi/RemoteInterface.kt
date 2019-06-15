package eventsgateway.rmi

import java.rmi.Remote
import java.rmi.RemoteException

interface RemoteInterface<T> : Remote {
    @Throws(RemoteException::class)
    fun message(): T
}
