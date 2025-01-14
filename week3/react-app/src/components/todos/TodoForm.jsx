import React, {useEffect, useState} from 'react'
import {TODO_CATEGORY_ICON} from '@/constants/icon'

const TodoForm = ({clickHandler,onClose,options}) => {
    // 각각의 입력폼을 개별 상태로 관리
    const [title, setTitle] = useState('');
    const [summary, setSummary] = useState('');
    const [category, setCategory] = useState('TODO');
    const eventListener = () => {
        clickHandler(title, summary, category);
        onClose();
    }
    return (
        <>
            <h3 className="text-3xl text-red-200">{options.title}</h3>
            <form className='my-2'>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='title'>Title</label>
                    <input className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                           type='text' id='title'
                           value={title}
                           onChange={event => setTitle(event.target.value)}
                    />
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='summary'>Summary</label>
                    <textarea className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                              id='summary' rows='5' value={summary} onChange={event => setSummary(event.target.value)}/>
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='category'>Category</label>
                    <select className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                            id='category'
                            value={category} onChange={event => setCategory(event.target.value)}>
                        <option value='TODO'>{TODO_CATEGORY_ICON.TODO} To do</option>
                        <option value='PROGRESS'>{TODO_CATEGORY_ICON.PROGRESS} On progress</option>
                        <option value='DONE'>{TODO_CATEGORY_ICON.DONE} Done</option>
                    </select>
                </div>

                <div className='flex justify-end gap-4'>
                    {/* TodoHeader로부터 props로 전달받은 onClose라는 콜백함수를 onClick 이벤트에 등록 */}
                    <button className='text-xl text-white' type='button' onClick={onClose}>Cancel</button>
                    <button className='px-6 py-3 text-xl text-red-200' type='button'
                            onClick={eventListener}>{options.buttonText}
                    </button>
                </div>
            </form>
        </>
    )
};
export default TodoForm