package client

import server.IServer
import java.rmi.server.UnicastRemoteObject

class IClientImpl(private val name: String, server: IServer, private val view: ChatView) : UnicastRemoteObject(), IClient {
    init {
        server.registerClient(this)
        val msg = "$name connected!"
        server.broadcastMessage(msg)
    }
    override fun getName() = name
    override fun retrieveMessage(msg: String) = view.txtChat.appendText("$msg\n")
}
