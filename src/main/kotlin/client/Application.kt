package client

import tornadofx.App
import tornadofx.launch

class Application : App(ChatView::class)

fun main() {
    launch<Application>()
}
