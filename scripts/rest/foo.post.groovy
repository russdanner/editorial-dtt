@Grab(group='org.apache.commons', module='commons-fileupload2-jakarta-servlet6', version='2.0.0-M2')

import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload
import org.apache.commons.fileupload.util.Streams

// import org.apache.commons.io.FilenameUtils
// import org.apache.commons.lang3.StringUtils
// import org.craftercms.commons.security.exception.PermissionException
// import org.craftercms.engine.exception.HttpStatusCodeException
// import org.craftercms.studio.api.v1.exception.ServiceLayerException
// import org.craftercms.studio.api.v2.exception.content.ContentExistException
// import scripts.api.ContentServices

def result = [:]

//def context = ContentServices.createContext(applicationContext, request)

if (JakartaServletFileUpload.isMultipartContent(request)) {
    def upload = new JakartaServletFileUpload()
    def iterator = upload.getItemIterator(request)
    while(iterator.hasNext()) {
        def item = iterator.next()
        def name = item.getFieldName()
        def stream = item.getInputStream()
        
        if(item.isFormField()) {
            println "Field : $name -> "+ Streams.asString(stream)
        }
        else {
            def contentType = item.getContentType()
            println "File : $name ->" + stream.size()
        }
    }
}
else {
    // throw an error
}
