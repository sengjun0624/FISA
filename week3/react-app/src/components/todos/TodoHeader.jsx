import React from 'react'
import TodoFilter from './TodoFilter'
import {createPortal} from "react-dom";
import Modal from "../ui/Modal.jsx";
import TodoForm from "./TodoForm.jsx";

const TodoHeader = ({addHandler,setCategories}) => {
    const [openModal, open] = React.useState(false);
    const options = {title: '할 일 등록', buttonText: 'Add'};
    return (
        <div className="flex items-center justify-between mb-2" id="task-control">
            <button onClick={() => open(true)}
                    className="px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
                    data-cy="add-todo-button">Add Todo
            </button>
            {openModal && createPortal(
                <Modal>
                    <TodoForm onClose={() => open(false)}  clickHandler={addHandler} options={options}/>
                </Modal>,
                document.body)}
            <TodoFilter setCategories={setCategories}/>
        </div>
    )
}
export default TodoHeader