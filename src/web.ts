import { WebPlugin } from '@capacitor/core';

import type { CapacitorRollbarPlugin } from './definitions';

export class CapacitorRollbarWeb
  extends WebPlugin
  implements CapacitorRollbarPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
