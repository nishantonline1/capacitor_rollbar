import { registerPlugin } from '@capacitor/core';

import type { CapacitorRollbarPlugin } from './definitions';

const CapacitorRollbar = registerPlugin<CapacitorRollbarPlugin>(
  'CapacitorRollbar',
  {
    web: () => import('./web').then(m => new m.CapacitorRollbarWeb()),
  },
);

export * from './definitions';
export { CapacitorRollbar };
