package restaurant

import org.springframework.http.HttpStatus

class Response {

    static HashMap<String, String> error(String message, HttpStatus status) {
        HashMap<String, String> response = new HashMap<String, String>()

        response.put('statusCode', status.value())
        response.put('message', message)

        return response
    }

    static def ok(params){
        def response = new HashMap()

        params.each { key, value ->
            response.put(key, value)
        }

        return response
    }

}
