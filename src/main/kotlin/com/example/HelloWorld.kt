package com.example

import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

val app: HttpHandler = routes(
    "/ping" bind GET to {
        Response(OK).body("pong")
    },
    "/pong" bind GET to { req: Request ->
        Response(OK).body("ping")
    }
)

val htmlPage =  """
    <html>
        <body>
        <h1 style="text-align:center; front-size:3em;">
    Hello Function World!
        </h1>
        </body>
       </html>"""

    val handler: HttpHandler = { Response(OK).body(htmlPage) }

    fun main(){
        handler.asServer(SunHttp(8080)).start()
    }
