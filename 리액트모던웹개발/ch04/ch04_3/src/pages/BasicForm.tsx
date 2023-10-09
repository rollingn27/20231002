import type { FormEvent, ChangeEvent } from 'react';
import { useState, useCallback } from 'react';
import { Title } from '../components';

export default function BasicForm() {
  const [name, setName] = useState<string>('');
  const [email, setEmail] = useState<string>('');

  const onSubmit = useCallback(
    (e: FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      const formData = new FormData();
      formData.append('name', name);
      formData.append('email', email);
      alert(JSON.stringify(Object.fromEntries(formData), null, 2));
    },
    [name, email]
  );

  const onChangeName = useCallback((e: ChangeEvent<HTMLInputElement>) => {
    setName(notUsed => e.target.value);
  }, []);

  const onChangeEmail = useCallback((e: ChangeEvent<HTMLInputElement>) => {
    setEmail(notUsed => e.target.value);
  }, []);

  return (
    <section className="mt-4 mb-8">
      <Title>BasicForm</Title>
      <div className="flex justify-center mt-4">
        <form onSubmit={onSubmit}>
          <div className="form-control">
            <label className="label" htmlFor="name">
              <span className="label-text">Username</span>
            </label>
            <input
              value={name}
              onChange={onChangeName}
              id="name"
              type="text"
              placeholder="enter your name"
              className="input input-primary"
            />
          </div>
          <div className="form-control">
            <label className="label" htmlFor="email">
              <span className="label-text">email</span>
            </label>
            <input
              value={email}
              onChange={onChangeEmail}
              id="email"
              type="email"
              placeholder="enter your email"
              className="input input-primary"
            />
          </div>
          <div className="flex justify-center mt-4">
            <input
              type="submit"
              value="Submit"
              className="w-1/2 btn btn-primary btn-sm"
            />
            <input defaultValue="Cancel" className="w-1/2 btn btn-sm ml-4" />
          </div>
        </form>
      </div>
    </section>
  );
}
