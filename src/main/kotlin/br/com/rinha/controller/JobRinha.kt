package br.com.rinha.controller

import br.com.rinha.repository.CacheRepository
import io.micronaut.scheduling.annotation.Scheduled
import jakarta.inject.Singleton
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*

@Singleton
class JobRinha(private val cacheRepository: CacheRepository) {

    companion object {
        private val LOG = LoggerFactory.getLogger(JobRinha::class.java)
    }

    @Scheduled(fixedDelay = "2s")
    fun saveALl() {
        runBlocking {
            LOG.info("Simple Job every 10 seconds: {}", SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()))
            cacheRepository.getAll()
        }
    }

}