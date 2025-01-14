import React from 'react';

const IconButton = ({icon, clickHandler}) => {
    return (
        <button className='w-8 text-xl font-semibold cursor-pointer ' onClick={clickHandler}>
            {icon}
        </button>
    )
}
export default IconButton;