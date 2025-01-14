import React from 'react'
import { TODO_CATEGORY_ICON } from '@/constants/icon'
const TodoFilter = ({setCategories}) => {
    return (
        <select className="p-2 text-gray-100 bg-gray-800 rounded"
                data-cy="todo-filter" defaultValue={"all"} onChange={(event)=>{
                    setCategories(event.target.value);
        }} >
            {/* defaultValue? - https://react.dev/reference/react-dom/components/select */}
            <option value="all" >All</option>
            <option value="TODO">{TODO_CATEGORY_ICON.TODO} To do</option>
            <option value="PROGRESS">{TODO_CATEGORY_ICON.PROGRESS} On progress</option>
            <option value="DONE">{TODO_CATEGORY_ICON.DONE} Done</option>
        </select>
    )
}
export default TodoFilter