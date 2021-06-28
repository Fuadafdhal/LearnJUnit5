package balajar.kotlin.unit.test

import belajar.kotlin.unit.test.App
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AppTest {
    @Test
    fun test() {
        val classUdderText = App()
        Assertions.assertNotNull(classUdderText.greeting, "app show greating")
    }

}