package br.com.pedrocunial.dummy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DummyApplication

fun main(args: Array<String>) {
	runApplication<DummyApplication>(*args)
}
