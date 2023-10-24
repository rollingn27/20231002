import * as T from './types';

const initialAppState: T.State = {};

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@listEntities/add':
      return { ...state, [action.payload.uuid]: action.payload };

    case '@listEntities/remove': {
      const newState = { ...state };
      delete newState[action.payload];
      return newState;
    }
  }
  return state;
};
