import React from 'react'
import TodoItem from "./TodoItem.jsx";



const TodoBody = ({updateHandler,todos,onDelete}) => {
    console.log(todos);
    return (
        <ul
            className='px-0 my-8'>
            {todos.map((todo) => <TodoItem updateHandler={updateHandler} todo={todo} onDelete={onDelete} key={todo.id}/>)}
        </ul>
    )
}
export default TodoBody