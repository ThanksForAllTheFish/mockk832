package org.t4atf.mockk832

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

sealed class Node

class Root : Node()
class Leaf : Node()

interface Factory {
    fun create() : Node
}

class FactoryImpl : Factory {
    override fun create(): Node = Root()
}

class MyTest {
    @Test
    fun aTest() {
        val mockk = mockk<Factory>()
        every { mockk.create() } returns Leaf()

        println(mockk.create())
    }
}
