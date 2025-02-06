import Todo from "./components/Todo.jsx";
import Form from "./components/Form.jsx";
import FilterButton from "./components/FilterButton.jsx";
import React, {useState} from "react";
import {nanoid} from "nanoid";

function App(props) {
    const [tasks, setTasks] = useState(props.tasks);

    const taskList = tasks.map((task) => (<Todo name={task.name} completed={task.completed} id={task.id}
                                                key={task.id}/>));

    function addTask(name) {
        const newTask = {id: `todo-${nanoid()}`, name, completed: false};
        console.log(newTask.id);

        setTasks([...tasks, newTask]);
    }
    const tasksNoun = taskList.length !== 1 ? "tasks" : "task";
    const headingText = `${taskList.length} ${tasksNoun} remaining`;
    return (
        <div className="todoapp stack-large">
            <h1>TodoMatic</h1>
            <Form addTask={addTask}/>
            <div className="filters btn-group stack-exception">
                <FilterButton/>
                <FilterButton/>
                <FilterButton/>
            </div>
            <h2 id="list-heading">{headingText}</h2>
            <ul
                role="list"
                className="todo-list stack-large stack-exception"
                aria-labelledby="list-heading">
                {taskList}
            </ul>
        </div>
    );
}


export default App
