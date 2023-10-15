import * as T from './types';

const initialAppState: T.State = new Date();

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@clock/setClock':
      return action.payload;
  }
  return state;
};
