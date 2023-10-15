import * as T from './types';

const initialAppState: T.State = [];

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@cards/addCard':
      return [action.payload, ...state];
    case '@cards/removeCard':
      return state.filter(card => card.uuid !== action.payload);
  }
  return state;
};
