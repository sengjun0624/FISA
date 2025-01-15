import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";
import React from "react";
import {TodoProvider} from "./components/context/TodoContext.jsx";



function App() {
    return (
        <>
            <DefaultLayout>
                <Header/>
                <section className='max-w-xl m-4 mx-auto'>
                    <TodoProvider>
                        <TodoHeader />
                        <TodoBody/>
                    </TodoProvider>
                </section>
            </DefaultLayout>
        </>
    )
}

export default App
