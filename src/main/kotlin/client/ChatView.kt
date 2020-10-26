package client

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import server.IServer
import tornadofx.*
import java.rmi.Naming

class ChatView : View("Buff ko phe") {
    lateinit var txtChat: TextArea
    private lateinit var send: Button
    private lateinit var client: IClientImpl
    private lateinit var server: IServer
    private lateinit var tfMessage: TextField
    private lateinit var tfName: TextField

    override val root = borderpane {
        top {
            hbox {
                alignment = Pos.CENTER
                tfName = textfield()
                button("SUBMIT") {
                    action {
                        server = Naming.lookup("rmi://localhost/rmi_chat") as IServer
                        client = IClientImpl(tfName.text, server, this@ChatView)
                        isDisable = true
                        tfName.isDisable = true
                        send.isDisable = false
                        tfMessage.isDisable = false
                    }
                }
            }
        }
        center {
            txtChat = textarea()
        }
        bottom {
            hbox {
                alignment = Pos.CENTER
                tfMessage = textfield {
                    isDisable = true
                }
                send = button("SEND") {
                    isDisable = true
                    action {
                        server.broadcastMessage("[${tfName.text}]: ${tfMessage.text}")
                        tfMessage.text = ""
                    }
                }
            }
        }
    }
}
