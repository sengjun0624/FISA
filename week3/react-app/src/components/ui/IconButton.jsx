import React from 'react';

const IconButton = ({icon, open}) => {
    return (
        <button className='w-8 text-xl font-semibold cursor-pointer ' onClick={open}>
            {icon}
        </button>
    )
}
export default IconButton;