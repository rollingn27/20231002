import { useRef, useCallback } from 'react';
import { Title } from '../components';
import type { ValidatableInputMethods } from '../theme/daisyui';
import { ValidatableInput } from '../theme/daisyui';

export default function ValidatableInputTest() {
  const methodRef = useRef<ValidatableInputMethods>(null);

  const validateEmail = useCallback(() => {
    if (methodRef.current) {
      const [valid, valueOrErrorMessage] = methodRef.current.validate();
      if (valid) alert(`${valueOrErrorMessage}는 유효한 이메일 주소입니다.`);
      else alert(valueOrErrorMessage);
    }
  }, []);

  return (
    <section className="mt-4">
      <Title>ValidatableInputTest</Title>
      <div className="flex justify-center mt-4">
        <div className="flex flex-col w-1/3 p-2">
          <ValidatableInput type="email" ref={methodRef} className="input-primary" />
          <button onClick={validateEmail} className="mt-4 btn btn-primary">
            validate
          </button>
        </div>
      </div>
    </section>
  );
}
