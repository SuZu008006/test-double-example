import BackyardImpl, { Backyard } from '@/main/Backyard.ts'

interface Store {
  searchItem(itemName: string): string
}


export default class StoreImpl implements Store {
  backyard: Backyard

  constructor(backyard: Backyard = new BackyardImpl()) {
    this.backyard = backyard
  }

  searchItem(itemName: string): string {
    return this.backyard.findItem(itemName)
  }
}
