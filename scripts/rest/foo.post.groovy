def parts = [:]
println "========================================================================================================================================"

request.reader.text.split('&').each { param ->
def (key, value) = param.split('=').collect { URLDecoder.decode(it, 'UTF-8') }
parts[key] = value
}
// Access individual fields
parts.each { key, value ->
println "parts: ${key}: ${value}"
}

params.each { key, value ->
println "param: ${key}: ${value}"
}