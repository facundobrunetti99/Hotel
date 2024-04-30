import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import AddRoom from "./components/room/AddRoom"
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "/node_modules/bootstrap/dist/js/bootstrap.min.js"
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <AddRoom/>
    </>
  )
}

export default App
