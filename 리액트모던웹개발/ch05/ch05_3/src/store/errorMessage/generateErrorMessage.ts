import { Dispatch } from 'redux';
import { setErrorMessage } from './actions';

export const generateErrorMessage =
  (errorMessage: string = 'some error occureed') =>
  (dispatch: Dispatch) => {
    dispatch(setErrorMessage(''));
    try {
      throw new Error(errorMessage);
    } catch (e) {
      if (e instanceof Error) dispatch(setErrorMessage(e.message));
    }
  };
