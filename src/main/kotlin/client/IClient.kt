package client

import java.rmi.Remote
import java.rmi.RemoteException
import kotlin.jvm.Throws

interface IClient : Remote {
    @Throws(RemoteException::class)
    fun getName(): String
    @Throws(RemoteException::class)
    fun retrieveMessage(msg: String)
}
