import React from 'react'
import {TODO_CATEGORY_ICON} from '@/constants/icon';
import IconButton from '../ui/IconButton';
import {createPortal} from "react-dom";
import Modal from "../ui/Modal.jsx";
import TodoForm from "./TodoForm.jsx";

const TodoItem = ({updateHandler,todo, onDelete}) => {
    const deleteById = () => {
        onDelete(todo.id);
    }
    const updateById = (title,summary,category) => {
        updateHandler(todo.id,title,summary,category);
    }
    const [openModal, open] = React.useState(false);
    const options = {title: '할 일 수정', buttonText: 'Update'};
    return (
        <li className="flex gap-4 justify-between my-4 py-4 px-4 border-[1px] bg-gray-700 rounded-md shadow-xl">
            <div>
                <span className="text-lg font-medium text-gray-300">{TODO_CATEGORY_ICON[todo.category]}</span>
                <div>
                    <h2 data-test="title" className="mb-0 text-lg font-bold text-gray-100 uppercase">{todo.title}</h2>
                    <p className="mt-2 text-base text-gray-200">{todo.summary}</p>
                </div>
            </div>
            <div className="flex items-center gap-1">
                <IconButton icon={'✏️'} open={() => open(true)}/>
                <IconButton textColor='text-red-300' icon={'🗑'} clickHandler={deleteById}/>
            </div>
            {openModal && createPortal(
                <Modal>
                    <TodoForm onClose={() => open(false)} clickHandler={updateById} options={options}/>
                </Modal>,
                document.body)}
        </li>
    );
}
export default TodoItem