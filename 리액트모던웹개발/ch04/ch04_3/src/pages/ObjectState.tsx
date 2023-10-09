import type { FormEvent, ChangeEvent } from 'react';
import { useState, useCallback } from 'react';
import { Title } from '../components';

type FormType = {
  name: string;
  email: string;
};

export default function ObjectState() {
  const [form, setForm] = useState<FormType>({ name: '', email: '' });

  const onSubmit = useCallback(
    (e: FormEvent<HTMLFormElement>) => {
      e.preventDefault();

      alert(JSON.stringify(form, null, 2));
    },
    [form]
  );

  const onChangeName = useCallback((e: ChangeEvent<HTMLInputElement>) => {
    setForm(form => ({ ...form, name: e.target.value }));
  }, []);

  const onChangeEmail = useCallback((e: ChangeEvent<HTMLInputElement>) => {
    setForm(form => ({ ...form, email: e.target.value }));
  }, []);

  return (
    <section className="mt-4 mb-8">
      <Title>ObjectState</Title>
      <div className="flex justify-center mt-4">
        <form onSubmit={onSubmit}>
          <div className="form-control">
            <label className="label" htmlFor="name">
              <span className="label-text">Username</span>
            </label>
            <input
              value={form.name}
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
              value={form.email}
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
