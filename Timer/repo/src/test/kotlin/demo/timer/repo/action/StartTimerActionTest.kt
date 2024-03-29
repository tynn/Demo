package demo.timer.repo.action

import demo.timer.repo.store.TimerStore
import io.mockk.coVerifyAll
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

internal class StartTimerActionTest {

    private val state = mockk<TimerStore>(relaxed = true)

    private val action = StartTimerAction(state)

    @Test
    fun `action should delegate to state start`() {
        runBlocking { action() }

        coVerifyAll { state.startTimer() }
    }
}
