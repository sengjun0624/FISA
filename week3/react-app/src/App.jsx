import './App.css'
import Counter from  './components/Counter.jsx'
import DefaultLayout from "./layouts/defaultLayout.jsx";

function App() {

    return (
        <>

            <DefaultLayout>
                <Counter />
            </DefaultLayout>
        </>
    )
}


export default App
