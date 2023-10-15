import * as T from './types';

const initialAppState: T.State = false;

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@loading/setLoadingAction':
      return action.payload;
  }
  return state;
};
