package server

import client.IClient
import java.rmi.server.UnicastRemoteObject

class IServerImpl(val name: String) : UnicastRemoteObject(), IServer {
    private val mClients = mutableListOf<IClient>()

    override fun broadcastMessage(msg: String) {
        mClients.forEach { it.retrieveMessage(msg) }
    }

    override fun registerClient(client: IClient) {
        mClients.add(client)
    }
}
