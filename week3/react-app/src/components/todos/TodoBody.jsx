import React from 'react'
import TodoItem from "./TodoItem.jsx";



const TodoBody = ({categories,updateHandler,todos,onDelete}) => {
    const filteredTodos = (categories === 'all'||categories===' ')
        ? todos
        : todos.filter((todo) => todo.category === categories);

    return (
        <ul
            className='px-0 my-8'>
            {filteredTodos.map((todo) => <TodoItem updateHandler={updateHandler} todo={todo} onDelete={onDelete} key={todo.id}/>)}
        </ul>
    )
}
export default TodoBody