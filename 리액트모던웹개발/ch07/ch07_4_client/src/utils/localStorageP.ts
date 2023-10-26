export const readItemFormStorageP = (key: string) =>
  new Promise<string | null>(async (resolve, reject) => {
    try {
      const value = localStorage.getItem(key);
      resolve(value);
    } catch (e) {
      reject(e);
    }
  });

export const writeItemFormStorageP = (key: string, value: string) =>
  new Promise<string | null>(async (resolve, reject) => {
    try {
      localStorage.setItem(key, value);
      resolve(value);
    } catch (e) {
      reject(e);
    }
  });

export const readStringP = readItemFormStorageP;
export const writeStringP = writeItemFormStorageP;
