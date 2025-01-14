import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";
import React, {useState} from "react";


function App() {
    /* 할 일 데이터를 하나의 상태로 관리 */
    const [todos, setTodos] = useState([]);
    const [categories, setCategories] = useState(' ');
    //모달을 열고, 모달 값을 내려주는 함수.

    const deleteHandler = (id) => {
        setTodos((prevTodos) => prevTodos.filter((todos) => todos.id !== id));
    }
    const addHandler = (title, summary, category) => {
        const todo =
            {
                id: self.crypto.randomUUID(),
                title: title,
                summary: summary,
                category: category,
            }
        const newTodos = [...todos, todo];
        setTodos(newTodos);
    }
    const updateHandler = (id, title, summary, category) => {
        const newTodo={id,title,summary,category};
        setTodos((prevTodos) =>
            prevTodos.map((todo) => (todo.id === id ? newTodo : todo))
        );
    }
    return (
        <>
            <DefaultLayout>
                <Header/>
                <section className='max-w-xl m-4 mx-auto'>
                    <TodoHeader addHandler={addHandler} setCategories={setCategories}/>
                    <TodoBody categories={categories} updateHandler={updateHandler} todos={todos} onDelete={deleteHandler}/>
                </section>
            </DefaultLayout>
        </>
    )
}

export default App
