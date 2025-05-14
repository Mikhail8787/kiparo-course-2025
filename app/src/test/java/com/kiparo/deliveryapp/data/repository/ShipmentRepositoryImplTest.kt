@file:OptIn(ExperimentalCoroutinesApi::class)

package com.kiparo.deliveryapp.data.repository

import com.kiparo.deliveryapp.data.mock.mockOperationsNetwork
import com.kiparo.deliveryapp.data.mock.mockShipmentNetwork
import com.kiparo.deliveryapp.data.network.api.ShipmentApi
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ShipmentRepositoryImplTest {

    private val shipmentApi: ShipmentApi = mockk()//FIXME
    private val repository = ShipmentRepositoryImpl(shipmentApi, Dispatchers.IO)//FIXME

    @Test
    fun `shipments grouped correctly`() = runTest {
        // Подготавливаем тестовые данные
        val shipmentWithHighlight = mockShipmentNetwork(operations = mockOperationsNetwork(highlight = true))
        val shipmentWithoutHighlight = mockShipmentNetwork(operations = mockOperationsNetwork(highlight = false))

        // Мокаем поведение shipmentApi
        coEvery { shipmentApi.getShipments() } returns listOf(shipmentWithHighlight, shipmentWithoutHighlight)

        // Вызываем тестируемый метод
        val result = repository.getGroupedByHighlight()

        // Проверяем результаты
        assertEquals(1, result.highlights.size) // Ожидаем 1 отправление с highlight
        assertEquals(1, result.others.size)     // Ожидаем 1 отправление без highlight

        // Убедимся, что метод getShipments был вызван
        verify { shipmentApi.getShipments() }
    }
}