import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";


const todos = [
    {
        id: 1,
        title: 'React 공부',
        summary: 'React를 공부한다.',
        category: 'TODO',
    },
    {
        id: 2,
        title: '점심 먹기',
        summary: '점심을 먹는다.',
        category: 'PROGRESS',
    },
    {
        id: 3,
        title: '커피 마시기',
        summary: '커피를 마신다.',
        category: 'DONE',
    }
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
