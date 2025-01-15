import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";
import React, {useState} from "react";


function App() {
    /* 할 일 데이터를 하나의 상태로 관리 */
    const [todos, setTodos] = useState([]);
    const [categories, setCategories] = useState('all');
    //모달을 열고, 모달 값을 내려주는 함수.
    const [showTooltip, setShowTooltip] = useState(true);

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
        const newTodo = {id, title, summary, category};
        setTodos((prevTodos) =>
            prevTodos.map((todo) => (todo.id === id ? newTodo : todo))
        );
    }

    return (
        <>
            <DefaultLayout>
                <Header/>
                <section className='max-w-xl m-4 mx-auto'>
                    {/* 툴팁 */}
                    <div className="relative">
                        {showTooltip && todos.length === 0 && (
                            <div
                                className="absolute bottom-full mb-2 px-3 py-2 text-sm text-gray-700 bg-red-200 rounded shadow-lg"
                            >
                                할 일이 없습니다. 새로운 할 일을 추가하세요!
                                <div
                                    className="absolute top-full  transform -translate-x-1/2 w-0 h-0 border-t-[6px] border-t-red-200 border-r-[6px] border-r-transparent border-l-[6px] border-l-transparent"
                                ></div>
                            </div>
                        )}
                    </div>
                    <TodoHeader todos={todos} addHandler={addHandler} setCategories={setCategories}/>
                    <TodoBody categories={categories} updateHandler={updateHandler} todos={todos}
                              onDelete={deleteHandler}/>
                </section>
            </DefaultLayout>
        </>
    )
}

export default App
