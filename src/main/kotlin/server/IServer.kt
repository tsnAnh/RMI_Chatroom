package server

import client.IClient
import java.rmi.Remote
import java.rmi.RemoteException
import kotlin.jvm.Throws

interface IServer : Remote {
    @Throws(RemoteException::class)
    fun broadcastMessage(msg: String)
    @Throws(RemoteException::class)
    fun registerClient(client: IClient)
}
