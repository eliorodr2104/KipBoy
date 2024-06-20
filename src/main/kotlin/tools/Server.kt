package tools

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.system.exitProcess

fun startServer(onCodeReceived: (String) -> Unit) {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/callback") {
                val code = call.request.queryParameters["code"]
                if (code != null) {
                    call.respondText("Authorization successful! You can close this window.", ContentType.Text.Html)
                    onCodeReceived(code)

                    exitProcess(9)
                } else {
                    call.respondText("Authorization failed.", ContentType.Text.Html)
                }
            }

            get("/") {
                call.respondText("PROVA", ContentType.Text.Html)
            }
        }
    }.start(wait = false)
}
