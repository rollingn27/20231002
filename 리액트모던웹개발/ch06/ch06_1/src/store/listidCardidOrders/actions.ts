import type * as T from './types';

export const setListidCardids = (payload: T.ListidCardids): T.SetListidCardids => ({
  type: '@listidCardids/set',
  payload,
});

export const removeListid = (payload: string): T.RemoveListidAction => ({
  type: '@listidCardids/remove',
  payload,
});

export const prependCardidToListid = (
  payload: T.ListidCardid
): T.PrependCardidToListidAction => ({
  type: '@listidCardids/prependCardid',
  payload,
});

export const appendCardidToListid = (
  payload: T.ListidCardid
): T.AppendCardidToListidAction => ({
  type: '@listidCarids/appendCardid',
  payload,
});

export const removeChardIdFromListId = (
  payload: T.ListidCardid
): T.RemoveCardidFromListidAction => ({
  type: '@listidCarids/removeCardid',
  payload,
});
