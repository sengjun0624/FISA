'use client'

import React, {useActionState} from 'react'
import {login} from "@/app/login/actions";
import {useFormStatus} from "react-dom";

const LoginForm = () => {
    const [state, loginAction] = useActionState(login, undefined);
    return (
        <div className="flex justify-center items-center mt-20">
            <form action={loginAction} className="flex flex-col gap-2">
                <input className="border-2 border-dashed w-80 h-10 outline-none" id="email" name="email"
                       placeholder="Email"/>
                {/* TODO: 입력폼 유효성 처리 */}
                {state?.errors?.email && <p className='text-red-500'>{state.errors.email}</p>}
                <input
                    className="border-2 border-dashed w-80 h-10 outline-none"
                    id="password"
                    name="password"
                    type="password"
                    placeholder="Password"
                />
                {/* TODO: 입력폼 유효성 처리 */}
                {state?.errors?.password && <p className='text-red-500'>{state.errors.password}</p>}
                <SubmitButton/>
            </form>
        </div>
    )
}

export default LoginForm

function SubmitButton() {

    const {pending} = useFormStatus();
    return (
        <button disabled = {pending} type="submit" className="text-white font-sans bg-gray-800 text-lg px-5 py-2.5 me-2 mb-2">
            Login
        </button>
    );
}
  