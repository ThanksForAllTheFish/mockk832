package org.t4atf.mockk832

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

sealed class Node

class Root : Node()
class Leaf : Node()

interface Factory {
    fun create() : Node
    fun copy(node: Node) : Node
}

open class MyTest {
    @Test
    open fun aTest() {
        val mockk = mockk<Factory>()
        every { mockk.create() } returns Leaf()

        println(mockk.create())

        every { mockk.copy(any()) } returns Root()
    }
}
