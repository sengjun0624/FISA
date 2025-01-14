import React from 'react'
import TodoFilter from './TodoFilter'
import {createPortal} from "react-dom";
import Modal from "../ui/Modal.jsx";
import TodoForm from "./TodoForm.jsx";

const TodoHeader = () => {
    // Modal의 open/close 여부를 관리하는 상태값
    const [openModal, open] = React.useState(false);
    return (
        <div className="flex items-center justify-between mb-2" id="task-control">
            {/*add Todo 버튼을 누르면 open modal상태값이 true로 바뀐다.*/}
            <button onClick={() => open(true)}
                    className="px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
                    data-cy="add-todo-button">Add Todo
            </button>
            {openModal && createPortal(
                <Modal>
                    {/*함수도 props로 전달 할 수 있다.*/}
                    {/*TodoHeader가 가진 open() 함수 시그니처를 onclose 라는 props이름으로 전달해줬다.*/}
                    <TodoForm onClose={() => open(false)}/>
                </Modal>,
                document.body
            )}
            <TodoFilter/>
        </div>
    )
}
export default TodoHeader