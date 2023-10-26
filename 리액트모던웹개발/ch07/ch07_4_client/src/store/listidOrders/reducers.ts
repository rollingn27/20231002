import * as T from './types';

const initialAppState: T.State = [];

export const reducer = (state: T.State = initialAppState, action: T.Actions) => {
  switch (action.type) {
    case '@listidOrders/set':
      return action.payload;
    case '@listidOrders/add':
      return [...state, action.payload];
    case '@listOrders/remove':
      return state.filter(uuid => uuid !== action.payload);
  }
  return state;
};
