import React from 'react'

const Modal = ({children,close}) => {
    return (
        <>
            {/*모달 배경 흐릿한 부분*/}
            <div onClick={close} data-cy="modal-backdrop" className='fixed top-0 left-0 w-full h-full backdrop-blur-md z-1'></div>
            {/*모달 다이얼로그 부분*/}
            <div  data-cy="modal-container" className='fixed z-10 w-1/2 p-8 m-0 transform -translate-x-1/2 -translate-y-1/2 border-none rounded shadow-xl top-1/2 left-1/2 bg-slate-600'>
                {children}
            </div>
        </>
    )
}

export default Modal



