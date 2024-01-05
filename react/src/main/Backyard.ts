export interface Backyard {
  findItem(itemName: string): string
}

export default class BackyardImpl implements Backyard {
  findItem(_: string): string {
    return ""
  }
}
