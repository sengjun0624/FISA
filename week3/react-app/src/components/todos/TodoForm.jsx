import React, {useEffect, useState} from 'react'
import {TODO_CATEGORY_ICON} from '@/constants/icon'

const TodoForm = ({onClose}) => {

    return (
        <>
            <h3 className="text-3xl text-red-200">할일 등록</h3>
            <form className='my-2'>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='title'>Title</label>
                    <input className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                           type='text' id='title'/>
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='summary'>Summary</label>
                    <textarea className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                              id='summary' rows='5'/>
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='category'>Category</label>
                    <select className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded'
                            id='category'>
                        <option value='TODO'>{TODO_CATEGORY_ICON.TODO} To do</option>
                        <option value='PROGRESS'>{TODO_CATEGORY_ICON.PROGRESS} On progress</option>
                        <option value='DONE'>{TODO_CATEGORY_ICON.DONE} Done</option>
                    </select>
                </div>

                <div className='flex justify-end gap-4'>
                    {/*Todoheader로부터 props로 전달 받은 onCloase라는 콜백함수를 onClock이벤트에 등록*/}
                    <button className='text-xl text-white' type='button' onClick={onClose}>Cancel</button>
                    <button className='px-6 py-3 text-xl text-red-200' type='button'>Add</button>
                </div>
            </form>
        </>
    )
};
export default TodoForm