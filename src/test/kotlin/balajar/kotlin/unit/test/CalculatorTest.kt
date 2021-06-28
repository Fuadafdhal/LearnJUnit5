package balajar.kotlin.unit.test

import balajar.kotlin.unit.test.generator.SimpleDisplayNameGenerator
import belajar.kotlin.unit.test.Calculator
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException

//@DisplayName("Test for Calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
class CalculatorTest {
    companion object {

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Sebelum semua unit test")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("Setelah semua unit test")
        }

    }

    private val calculator = Calculator()


    @BeforeEach
    fun beforeEach() {
        println("Sebelum Unit Test")
    }

    @AfterEach
    fun afterEach() {
        println("Seteletah Unit Test")
    }


    @Test
//    @DisplayName("Test for Calculator.add(1,1)")
    fun testAddSucceed() {
        println("Unit Test testAddSuccess")
        val result = calculator.add(1, 1)
        assertEquals(2, result, "Hasil Harus = 2")
    }

    @Test
//    @DisplayName("Test for Calculator.divide(100,10)")
    fun testDivideSucceed() {
        println("Unit Test testDivideSuccess")
        val result = calculator.divide(100, 10)
        assertEquals(10, result)
    }

    @Test
//    @DisplayName("Test for Calculator.divide(100,0)")
    fun testDivideFailed() {
        println("Unit Test testDivideFailed")
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

    @Test
    @Disabled("Coming Soon")
    fun testComingSong() {
        // belum selesai
    }

    @Test
    fun testAborted() {
        val profile = System.getenv()["PROFILE"]
        if (profile != "DEV") {
            throw TestAbortedException()
        }
        println("Test Not Aborted becausse Dev Profile")

    }

    @Test
    fun testAssumptions() {
        assumeTrue("DEV" == System.getenv()["PROFILE"])

        println("Test Not Aborted because Dev Profile")
    }
}