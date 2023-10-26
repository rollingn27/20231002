import * as L from './localStorageP';

export const readObjectP = <T extends object>(key: string) =>
  new Promise<T | null>((resolve, reject) => {
    L.readStringP(key).then(value => resolve(value ? JSON.parse(value) : null));
  });

export const writeObjectP = (key: string, value: object) =>
  L.writeStringP(key, JSON.stringify(value));
