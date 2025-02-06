import React from 'react';

const IconButton = ({icon, onClick}) => {
    return (
        <button className='w-8 text-xl font-semibold cursor-pointer ' onClick={onClick}>
            {icon}
        </button>
    )
}
export default IconButton;
