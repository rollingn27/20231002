import * as T from './types';

const initialAppState: T.State = 0;

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@counter/setCounter':
      return state + action.payload;
  }

  return state;
};
