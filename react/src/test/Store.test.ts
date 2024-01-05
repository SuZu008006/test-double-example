import BackyardImpl from '@/main/Backyard.ts'
import StoreImpl from '@/main/Store.ts'
import { describe, expect, test, vi } from 'vitest'

vi.mock('@/main/Backyard')

describe('Store',()=>{
  test('dummyTest',()=>{
    // arrange
    const mockBackyard = new BackyardImpl()
    const mockFindItem = vi.spyOn(mockBackyard,'findItem')
    mockFindItem.mockImplementation(()=>{
      throw new Error()
    })
    const store = new StoreImpl(mockBackyard)

    // assert
    expect(()=>{
      // act
      const unusedArgumentValue = ''
      store.searchItem(unusedArgumentValue)
    }).toThrow(Error)
  })

  test('spyTest',()=>{
    // arrange
    const mockBackyard = new BackyardImpl()
    const mockFindItem = vi.spyOn(mockBackyard,'findItem')
    const store = new StoreImpl(mockBackyard)

    // act
    const expectedItemName = 'eternal youth'
    store.searchItem(expectedItemName)

    // assert
    expect(mockFindItem).toHaveBeenCalledWith(expectedItemName)
  })

  test('stubTest',()=>{
    // arrange
    const mockBackyard = new BackyardImpl()
    const mockFindItem = vi.spyOn(mockBackyard,'findItem')
    const expectedItemLocation = 'area 13'
    mockFindItem.mockImplementation(()=>{
      return expectedItemLocation
    })
    const store = new StoreImpl(mockBackyard)

    // act
    const unusedArgumentValue = ''
    const actualItemLocation = store.searchItem(unusedArgumentValue)

    // assert
    expect(actualItemLocation).toEqual(expectedItemLocation)
  })
})