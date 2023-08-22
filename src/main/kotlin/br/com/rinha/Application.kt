package br.com.rinha

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import io.micronaut.runtime.Micronaut.build
import jakarta.inject.Singleton
import java.text.SimpleDateFormat


fun main(args: Array<String>) {
    build()
        .args(*args)
        .packages("br.com.rinha")
        .eagerInitConfiguration(true)
        .start()
}

@Singleton
internal class ObjectMapperBeanEventListener : BeanCreatedEventListener<ObjectMapper?> {
    override fun onCreated(event: BeanCreatedEvent<ObjectMapper?>): ObjectMapper? {
        val mapper: ObjectMapper? = event.bean
        mapper?.registerModule(JavaTimeModule())
        mapper?.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        mapper?.dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return mapper
    }


}
