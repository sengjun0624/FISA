import React from 'react'

const todos = [1, 2, 3];
const TodoBody = () => {
    return (
        <ul
            className='px-0 my-8'>
            {todos.map((todo,index) => <div>{todo}</div>)}
        </ul>
    )
}
export default TodoBody