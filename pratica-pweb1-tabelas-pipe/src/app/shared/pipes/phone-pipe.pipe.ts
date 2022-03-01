import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'phonePipe'
})
export class PhonePipePipe implements PipeTransform {

  transform(phone: string): string {
    if (phone) {
      if (phone.length === 8) {
        return `${phone.substring(0, 4)}-${phone.substring(4)}`;
      } else if (phone.length === 10 || phone.length === 11) {
        if (phone.length === 10) {
          phone = '0' + phone;
        }
        return `(${phone.substring(0, 3)}) ${phone.substring(3, 7)}-${phone.substring(7)}`;
      }
    }
    return phone;
  }
}
