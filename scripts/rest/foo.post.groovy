println "========================================================================================================================================"

def parts = request.getParts()

// reader.text.split('&').each { param ->
// def (key, value) = param.split('=').collect { URLDecoder.decode(it, 'UTF-8') }
// parts[key] = value
// }

println "List Parts:"+request.class
parts.each { part ->
   println " - Part: "+part.getName()
}
// Access individual fields
//parts.each { key, value ->
//println "parts: ${key}: ${value}"
//}

println ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"

params.each { key, value ->
println "param: ${key}: ${value}"
}