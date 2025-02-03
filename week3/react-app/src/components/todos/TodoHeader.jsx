import React from 'react'
import TodoFilter from './TodoFilter'
import {createPortal} from "react-dom";
import Modal from "../ui/Modal.jsx";
import TodoForm from "./TodoForm.jsx";
import {useTodosDispatch} from "../context/TodoContext.jsx";

const TodoHeader = () => {
    const [openModal, open] = React.useState(false);
    const options = {title: '할 일 등록', buttonText: 'Add'};
    const dispatch = useTodosDispatch();
    const addHandler = (title,summary,category) => {
        dispatch({type:'ADD',newTodo: {id:self.crypto.randomUUID(),title,summary,category}});
    }
    return (
        <div className="flex items-center justify-between mb-2" id="task-control">

                <button onClick={() => open(true)}
                        className=" px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
                        data-cy="add-todo-button">Add Todo
                </button>
            {openModal && createPortal(
                <Modal close={()=>open(false)}>
                    <TodoForm onClose={() => open(false)} options={options} callback={addHandler}/>
                </Modal>,
                document.body)}
            <TodoFilter />
        </div>
    );
}
export default TodoHeader