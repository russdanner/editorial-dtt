@Grab(group='org.apache.commons', module='commons-fileupload2-jakarta-servlet6', version='2.0.0-M2')

import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload
import org.apache.commons.fileupload.util.Streams
import org.apache.commons.io.FilenameUtils

def result = [:]

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
            def contenttype = item.getContentType()

            name = FilenameUtils.getName(name)

            println "File : $name ($contenttype) -> "+stream.available+" bytes"
        }
    }
}

return result