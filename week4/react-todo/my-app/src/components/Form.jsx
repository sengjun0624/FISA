import React, {useState} from "react";

const Form = (props) => {
    const [name, setName] = useState("");

    function handleSubmit(e) {
        e.preventDefault();
        props.addTask(name);
        setName("");
    }

    function handleChange(e) {
        const value = e.target.value.trim();
        if(value.length<=10) setName(e.target.value);
        else console.log('이름은 10글자까지만 입력 가능합니다.');

    }
    return (
        <form onSubmit={handleSubmit}>
            <h2 className="label-wrapper">
                <label htmlFor="new-todo-input" className="label__lg">
                    What needs to be done?
                </label>
            </h2>
            <input
                type="text"
                id="new-todo-input"
                className="input input__lg"
                name="text"
                autoComplete="off"
                value={name}
                onChange={handleChange}
            />
            <button type="submit" className="btn btn__primary btn__lg">
                Add
            </button>
        </form>
    );
};

export default Form;
