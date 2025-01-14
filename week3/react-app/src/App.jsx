import DefaultLayout from './layouts/DefaultLayout'
import TodoBody from "./components/todos/TodoBody.jsx";
import TodoHeader from "./components/todos/TodoHeader.jsx";
import Header from "./components/header/Header.jsx";

function App() {

    return (
        <>
            <DefaultLayout>
                <Header/>
                <section className='max-w-xl m-4 mx-auto'>
                    {/* Todo Header - 할일 추가, 필터링 UI*/}
                    {/* Todo Body -할 일 목록 UI*/}
                    <TodoHeader/>
                    <TodoBody/>
                </section>

            </DefaultLayout>
        </>
    )
}

export default App
