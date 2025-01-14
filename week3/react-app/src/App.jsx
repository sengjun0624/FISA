import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";


const todos = [

]
function App() {

    return (
        <>
            <DefaultLayout>
                <Header/>
                <section className='max-w-xl m-4 mx-auto'>
                    <TodoHeader/>
                    <TodoBody todos={todos}/>
                </section>

            </DefaultLayout>
        </>
    )
}

export default App
