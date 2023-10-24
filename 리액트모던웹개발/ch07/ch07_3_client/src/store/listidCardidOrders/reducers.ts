import * as T from './types';

const initialAppState: T.State = {};

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@listidCardids/remove': {
      const newState = { ...state };
      delete newState[action.payload];
      return newState;
    }

    case '@listidCardids/prependCardid': {
      const cardids = state[action.payload.listid];
      return { ...state, [action.payload.listid]: [action.payload.cardid, ...cardids] };
    }

    case '@listidCarids/appendCardid': {
      const cardids = state[action.payload.listid];
      return { ...state, [action.payload.listid]: [...cardids, action.payload.cardid] };
    }

    case '@listidCardids/set':
      return { ...state, [action.payload.listid]: action.payload.cardids };

    case '@listidCarids/removeCardid': {
      const cardids = state[action.payload.listid];
      return {
        ...state,
        [action.payload.listid]: cardids.filter(id => id !== action.payload.cardid),
      };
    }
  }
  return state;
};
