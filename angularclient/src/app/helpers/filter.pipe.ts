import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(items: any[], filters: any): any[] {
    if (!items) return [];
    if (!filters || Object.keys(filters).every(key => !filters[key])) return items;

    return items.filter(item => {
      for (const key in filters) {
        if (Object.prototype.hasOwnProperty.call(filters, key) && filters[key]) {
          const filterValue = filters[key]?.toLowerCase() || '';
          const itemValue = this.getPropertyValue(item, key)?.toString().toLowerCase() || '';

          if (!itemValue.includes(filterValue)) {
            return false;
          }
        }
      }
      return true;
    });
  }

  private getPropertyValue(obj: any, key: string): any {
    if (!obj || !key) return null;

    const keys = key.split('.');
    let value = obj;
    for (const k of keys) {
      value = value[k];
      if (value === undefined) {
        return null;
      }
    }
    return value;
  }
}
