import React,{useState} from 'react';

const Tooltip = () => {
    const [isVisible, setIsVisible] = useState(true);

    const closeTooltip = () => {
        setIsVisible(false);
    };

    return (
        isVisible && (
            <div className="relative">
                <div className=" bg-purple-500 text-white px-4 py-2 rounded shadow-lg w-80">
                    <div className="flex justify-between items-center">
                        <span>환영합니다 아래 버튼을 클릭해 투두를 추가해보세요.</span>
                        <button
                            onClick={closeTooltip}
                            className="ml-2 text-white font-bold"
                        >
                            &times;
                        </button>
                    </div>
                </div>
            </div>
        )
    );
};

export default Tooltip;